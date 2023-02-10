package com.cxcommerce.projetofinal.service;

import com.cxcommerce.projetofinal.model.EnderecoModel;
import com.cxcommerce.projetofinal.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoModel createEndereco(EnderecoModel enderecoModel){
        enderecoRepository.save(enderecoModel);
        return enderecoModel;
    }

}
