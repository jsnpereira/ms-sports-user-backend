package com.sports.user.controller;

import com.sports.user.dto.request.UserNewDTO;
import com.sports.user.dto.request.UserResponseDTO;
import com.sports.user.exception.UserIdNotFoundException;
import com.sports.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserById(@PathVariable(name = "id") String userId) throws UserIdNotFoundException {
        UserResponseDTO user;
        user = userService.getUserById(userId);
        return user;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO postUser(@RequestBody UserNewDTO userDTO) {
        return userService.saveUser(userDTO);
    }

}
