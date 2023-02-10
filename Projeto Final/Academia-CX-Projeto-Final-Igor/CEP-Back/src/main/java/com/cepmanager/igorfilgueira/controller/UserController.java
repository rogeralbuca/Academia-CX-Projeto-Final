package com.cepmanager.igorfilgueira.controller;

import com.cepmanager.igorfilgueira.handler.exceptions.RecursoNaoEncontradoException;
import com.cepmanager.igorfilgueira.handler.exceptions.ParametroInvalidoException;
import com.cepmanager.igorfilgueira.model.UserModel;
import com.cepmanager.igorfilgueira.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        try {
            return userService.getUserById(id);
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        try {
            return userService.createUser(user);
        } catch (ParametroInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel user) {
        try {
            return userService.updateUser(id, user);
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (ParametroInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}
