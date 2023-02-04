package com.academiacx.controller;


import com.academiacx.model.EnderecoModel;
import com.academiacx.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @PostMapping
    public ResponseEntity<EnderecoModel> inserir(@RequestBody EnderecoModel enderecoModel) {

        EnderecoModel response = enderecoService.inserir(enderecoModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

}
