package com.sports.user.service;

import com.sports.user.dto.mapper.UserMapper;
import com.sports.user.dto.request.UserNewDTO;
import com.sports.user.dto.request.UserResponseDTO;
import com.sports.user.entity.User;
import com.sports.user.exception.UserIdNotFoundException;
import com.sports.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO getUserById(String id) throws UserIdNotFoundException {
       Optional<User> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UserIdNotFoundException(id)));
       if (user.isPresent()){
            return UserMapper.toDTO(user.get());
       }
       return UserMapper.toDTO(new User());
    }

    public UserResponseDTO saveUser(UserNewDTO userDTO) {

        convertPWDEncoder(userDTO);

       User user = userRepository.save(UserMapper.toEntity(userDTO));
       return UserMapper.toDTO(user);
    }

    private void convertPWDEncoder(UserNewDTO userNewDTO){
        userNewDTO.setPassword(passwordEncoder.encode(userNewDTO.getPassword()));
    }
}
