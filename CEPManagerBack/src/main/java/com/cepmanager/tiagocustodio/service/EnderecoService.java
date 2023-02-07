package com.cepmanager.tiagocustodio.service;

import com.cepmanager.tiagocustodio.model.EnderecoModel;
import com.cepmanager.tiagocustodio.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// serviço de Endereco que gerencia as operações de persistência de endereços no banco de dados
// (create, read, update, delete) através do repositório EnderecoRepository.
@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoModel createEndereco(EnderecoModel endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<EnderecoModel> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel getEnderecoById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public EnderecoModel updateEndereco(Long id, EnderecoModel endereco) {
        EnderecoModel enderecoToUpdate = enderecoRepository.findById(id).orElse(null);
        if (enderecoToUpdate != null) {
            enderecoToUpdate.setUsername(endereco.getUsername());
            enderecoToUpdate.setCep(endereco.getCep());
            enderecoToUpdate.setNome(endereco.getNome());
            enderecoToUpdate.setRua(endereco.getRua());
            enderecoToUpdate.setBairro(endereco.getBairro());
            enderecoToUpdate.setCidade(endereco.getCidade());
            enderecoToUpdate.setEstado(endereco.getEstado());
            enderecoToUpdate.setNumero(endereco.getNumero());
            enderecoToUpdate.setDatetime(endereco.getDatetime());
            enderecoRepository.save(enderecoToUpdate);
            return enderecoToUpdate;
        } else {
            return null;
        }
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}