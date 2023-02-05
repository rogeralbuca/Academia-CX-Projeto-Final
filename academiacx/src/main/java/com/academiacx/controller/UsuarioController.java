package com.academiacx.controller;


import com.academiacx.model.UsuarioModel;
import com.academiacx.service.UsuarioService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioModel> findByUsernameAndPassword(@RequestBody UsuarioModel usuarioModel) {

        UsuarioModel response = usuarioService.findByUsernameAndPassword(usuarioModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

}
