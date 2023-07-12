package com.sports.user.dto.request;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserNewDTO {
    private String name;
    private String email;
    private String password;
}
