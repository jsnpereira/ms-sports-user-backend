package com.sports.user.dto.mapper;

import com.sports.user.dto.request.UserDTO;
import com.sports.user.entity.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
