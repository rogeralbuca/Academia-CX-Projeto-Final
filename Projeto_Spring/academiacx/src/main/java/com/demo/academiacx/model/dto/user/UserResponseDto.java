package com.demo.academiacx.model.dto.user;

import com.demo.academiacx.model.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String email;
    private String username;
    private boolean sucess;
    public UserResponseDto() {
    }

    public UserResponseDto(UserModel userModel) {
        this.id = userModel.getId();
        this.email = userModel.getEmail();
        this.username = userModel.getUsername();
        this.sucess = true;
    }
}
