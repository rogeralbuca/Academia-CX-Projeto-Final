package com.cepmanager.tiagocustodio.controller;

import com.cepmanager.tiagocustodio.handler.exceptions.RecursoNaoEncontradoException;
import com.cepmanager.tiagocustodio.handler.exceptions.ParametroInvalidoException;
import com.cepmanager.tiagocustodio.model.EnderecoModel;
import com.cepmanager.tiagocustodio.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// Controlador REST para a entidade "Endereço" e tem métodos para realizar operações CRUD
// Ela usa um objeto EnderecoService para executar as ações requisitadas.
@CrossOrigin(origins = {"*"})
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
        try {
            return enderecoService.getAllEnderecos();
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    // POST - Cria novo endereço
    @PostMapping
    public EnderecoModel createEndereco(@RequestBody EnderecoModel endereco) {
        try {
            return enderecoService.createEndereco(endereco);
        } catch (ParametroInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    // GET by ID - Busca um endereço específico
    @GetMapping("/{id}")
    public EnderecoModel getEnderecoById(@PathVariable("id") Long id) {

        try {
            return enderecoService.getEnderecoById(id);
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    // PUT - Atualiza um endereço específico
    @PutMapping("/{id}")
    public EnderecoModel updateEndereco(@PathVariable("id") Long id, @RequestBody EnderecoModel endereco) {
        try {
            return enderecoService.updateEndereco(id, endereco);
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (ParametroInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    // DELETE - Deleta um endereço específico
    @DeleteMapping("/{id}")
    public void deleteEndereco(@PathVariable("id") Long id) {
        try {
            enderecoService.deleteEndereco(id);
        } catch (RecursoNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}