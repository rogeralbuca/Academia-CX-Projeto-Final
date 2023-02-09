package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.ClienteModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public class ClienteDto {


    private Long id;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public ClienteDto() {
    }

    public ClienteDto(ClienteModel clienteModel){
        this.id = clienteModel.getId();
        this.username = clienteModel.getUsername();
        this.password = clienteModel.getPassword();
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPasswordDecrypt(){
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
