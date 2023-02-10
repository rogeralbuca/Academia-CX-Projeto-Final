package com.example.cadastro.model.dto;

import com.example.cadastro.model.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDto {

    private Long id;
    private String nome;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public UserDto() {
    }

    public UserDto(UserModel userModel) {
        this.id = userModel.getId();
        this.cep = userModel.getCep();
        this.nome = userModel.getNome();
        this.rua = userModel.getRua();
        this.numero = userModel.getNumero();
        this.bairro = userModel.getBairro();
        this.cidade = userModel.getCidade();
        this.estado = userModel.getEstado();
        this.username = userModel.getUsername();
        this.password = userModel.getPassword();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return new BCryptPasswordEncoder().encode(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
