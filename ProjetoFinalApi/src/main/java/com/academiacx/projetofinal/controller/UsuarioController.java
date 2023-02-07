package com.academiacx.projetofinal.controller;

import com.academiacx.projetofinal.model.CadastroUsuario;
import com.academiacx.projetofinal.model.LoginUsuario;
import com.academiacx.projetofinal.model.ViaCepModel;
import com.academiacx.projetofinal.repository.UsuarioRepository;
import com.academiacx.projetofinal.service.UsuarioService;
import com.academiacx.projetofinal.service.ViaCepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    private final UsuarioService service;

    private final ViaCepService viaCepService;

    public UsuarioController(UsuarioRepository repository, UsuarioService service, ViaCepService viaCepService) {
        this.repository = repository;
        this.service = service;
        this.viaCepService = viaCepService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CadastroUsuario>> findAllByUsuarios() {

        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastroUsuario> Post(@RequestBody CadastroUsuario usuario) {
        Optional<CadastroUsuario> user = service.CadastrarUsuario(usuario);

        try {
            return ResponseEntity.ok(user.get());

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }

    }
    @PostMapping("/logar")
    public ResponseEntity<LoginUsuario> Autentication(@RequestBody Optional<LoginUsuario> userLogin) {
        return service.Logar(userLogin).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @GetMapping("/cep/{cep}")
    public ViaCepModel test(@PathVariable String cep){
        return viaCepService.getViaCep(cep);
    }
}
