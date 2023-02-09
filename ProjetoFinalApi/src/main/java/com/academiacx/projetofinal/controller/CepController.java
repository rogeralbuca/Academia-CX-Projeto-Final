package com.academiacx.projetofinal.controller;

import com.academiacx.projetofinal.model.ViaCepModel;
import com.academiacx.projetofinal.repository.UsuarioRepository;
import com.academiacx.projetofinal.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public ViaCepModel test(@PathVariable String cep){
        return viaCepService.getViaCep(cep);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ViaCepModel> Post(@RequestBody ViaCepModel cepModel){
        Optional<ViaCepModel> cep = viaCepService.cadastrarCep(cepModel);
        try {
            return ResponseEntity.ok(cep.get());

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        List<ViaCepModel> response = viaCepService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }
}
