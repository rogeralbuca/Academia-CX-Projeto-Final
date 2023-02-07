package com.cepmanager.tiagocustodio.controller;

import com.cepmanager.tiagocustodio.handler.exceptions.RecursoNaoEncontradoException;
import com.cepmanager.tiagocustodio.handler.exceptions.ParametroInvalidoException;
import com.cepmanager.tiagocustodio.model.UserModel;
import com.cepmanager.tiagocustodio.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// Controlador REST para a entidade "User" e tem métodos para realizar operações CRUD
// Ela usa um objeto UserService para executar as ações requisitadas.
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
