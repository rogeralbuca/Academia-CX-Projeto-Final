package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Column(nullable = true, unique = true)
    private String email;
    @Column(nullable = true)
    private Boolean flAdmin;
    @Column(nullable = true)
    private Boolean flCliente;
    @Column(nullable = true, unique = true)
    private String username;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String cpf;

    public UserModel() {
    }

    public UserModel(UserDto userDto) {
        this.email = userDto.getEmail();
        this.nome = userDto.getNome();
        this.password = userDto.getPassword();
        this.username = userDto.getUsername();
        this.cpf = userDto.getCpf();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
