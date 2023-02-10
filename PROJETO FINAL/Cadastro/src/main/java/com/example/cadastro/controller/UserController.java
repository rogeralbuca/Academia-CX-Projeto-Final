package com.example.cadastro.controller;

import com.example.cadastro.model.dto.UserDto;
import com.example.cadastro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<UserDto> response =  userService.findall();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id){

        return userService.findById(id);
    }

    @PostMapping("/save")
    public UserDto insert(@RequestBody UserDto userDto) {

        return userService.insert(userDto);
    }

    @PutMapping("/update")
    public UserDto update(@RequestBody UserDto userDto) {

        return userService.update(userDto);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return userService.delete(id);
    }
}
