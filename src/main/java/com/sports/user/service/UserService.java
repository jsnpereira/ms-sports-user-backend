package com.sports.user.service;

import com.sports.user.dto.mapper.UserMapper;
import com.sports.user.dto.request.UserDTO;
import com.sports.user.entity.User;
import com.sports.user.exception.UserIdNotFoundException;
import com.sports.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(String id) throws UserIdNotFoundException {
       Optional<User> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UserIdNotFoundException(id)));
       if (user.isPresent()){
            return UserMapper.toDTO(user.get());
       }
       return UserMapper.toDTO(new User());
    }
}
