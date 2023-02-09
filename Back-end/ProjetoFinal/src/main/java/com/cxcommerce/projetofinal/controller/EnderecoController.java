package com.cxcommerce.projetofinal.controller;

import com.cxcommerce.projetofinal.model.EnderecoModel;
import com.cxcommerce.projetofinal.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;


    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<?> createEndereco(@RequestBody EnderecoModel enderecoModel){
        return ResponseEntity.ok(enderecoService.createEndereco(enderecoModel));
    }
}
