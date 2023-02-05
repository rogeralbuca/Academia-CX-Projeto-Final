package com.cepmanager.tiagocustodio.controller;

import com.cepmanager.tiagocustodio.model.UserModel;
import com.cepmanager.tiagocustodio.service.UserService;
import org.springframework.web.bind.annotation.*;

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
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
