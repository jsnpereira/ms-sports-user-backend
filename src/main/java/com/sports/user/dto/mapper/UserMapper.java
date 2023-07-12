package com.sports.user.dto.mapper;

import com.sports.user.dto.request.UserNewDTO;
import com.sports.user.dto.request.UserResponseDTO;
import com.sports.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {



    public static UserResponseDTO toDTO(User user){
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public static User toEntity(UserNewDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        return user;
    }


}
