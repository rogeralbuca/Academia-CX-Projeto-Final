package com.cepmanager.igorfilgueira.controller;

import com.cepmanager.igorfilgueira.handler.exceptions.RecursoNaoEncontradoException;
import com.cepmanager.igorfilgueira.handler.exceptions.ParametroInvalidoException;
import com.cepmanager.igorfilgueira.model.EnderecoModel;
import com.cepmanager.igorfilgueira.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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