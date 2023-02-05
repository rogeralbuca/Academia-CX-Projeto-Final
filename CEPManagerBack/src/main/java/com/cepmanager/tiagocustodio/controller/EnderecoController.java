package com.cepmanager.tiagocustodio.controller;

import com.cepmanager.tiagocustodio.model.EnderecoModel;
import com.cepmanager.tiagocustodio.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST para a entidade "Endereço" e tem métodos para realizar operações CRUD
// Ela usa um objeto EnderecoService para executar as ações requisitadas.
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    // GET ALL - Lista todos os endereços cadastrados
    @GetMapping
    public List<EnderecoModel> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    // POST - Cria novo endereço
    @PostMapping
    public EnderecoModel createEndereco(@RequestBody EnderecoModel endereco) {
        return enderecoService.createEndereco(endereco);
    }

    // GET by ID - Busca um endereço específico
    @GetMapping("/{id}")
    public EnderecoModel getEnderecoById(@PathVariable("id") Long id) {
        return enderecoService.getEnderecoById(id);
    }

    // PUT - Atualiza um endereço específico
    @PutMapping("/{id}")
    public EnderecoModel updateEndereco(@PathVariable("id") Long id, @RequestBody EnderecoModel endereco) {
        return enderecoService.updateEndereco(id, endereco);
    }

    // DELETE - Deleta um endereço específico
    @DeleteMapping("/{id}")
    public void deleteEndereco(@PathVariable("id") Long id) {
        enderecoService.deleteEndereco(id);
    }
}