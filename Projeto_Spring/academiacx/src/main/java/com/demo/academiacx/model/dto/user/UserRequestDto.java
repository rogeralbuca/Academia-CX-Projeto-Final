package com.demo.academiacx.model.dto.user;

import com.demo.academiacx.model.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String nome;
    private String email;
    private String cpf;
    private String username;
    private String password;

    public UserRequestDto() {
    }

    public UserRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserRequestDto(UserModel userModel) {
        this.email = userModel.getEmail();
        this.nome = userModel.getNome();
        this.username = userModel.getUsername();
        this.password = userModel.getPassword();
        this.cpf = userModel.getCpf();
    }
}
