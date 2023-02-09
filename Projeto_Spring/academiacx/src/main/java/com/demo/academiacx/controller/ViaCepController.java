package com.demo.academiacx.controller;

import com.demo.academiacx.model.ViaCepModel;
import com.demo.academiacx.service.ViaCepService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cep")
@AllArgsConstructor
public class ViaCepController {

    private final ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public ResponseEntity<?> getViaCep(@PathVariable String cep) {

        ViaCepModel response = viaCepService.getViaCep(cep);

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }
}