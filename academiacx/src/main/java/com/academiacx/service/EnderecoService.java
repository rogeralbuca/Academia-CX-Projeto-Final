package com.academiacx.service;

import com.academiacx.handler.exceptions.ErroAoAdicionarEnderecoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.model.EnderecoModel;
import com.academiacx.model.UsuarioModel;
import com.academiacx.repository.EnderecoRepository;
import com.academiacx.utils.ValidacaoUtils;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    public EnderecoModel inserir(EnderecoModel enderecoModel) {

        validarEndereco(enderecoModel);

        enderecoModel.setUsuario(new UsuarioModel(enderecoModel.getUsuario().getId()));

        try {
            enderecoRepository.save(enderecoModel);
            return enderecoModel;
        } catch (Exception e) {
            throw new ErroAoAdicionarEnderecoException("Erro ao adicionar endereço!");
        }

    }


    public void validarEndereco(EnderecoModel enderecoModel) {
        ValidacaoUtils.validarNumeroEndereco(enderecoModel.getNumero(), "Número não foi inserido ou é inválido!");
        ValidacaoUtils.validarCep(enderecoModel.getCep(), "CEP não foi inserido ou é inválido!");
        ValidacaoUtils.validarVazio(enderecoModel.getCidade(), "A cidade é obrigatória!");
        ValidacaoUtils.validarRangeTamanho(enderecoModel.getUf(), 2, 2, "UF não foi inserida ou é inválida!");
        ValidacaoUtils.validarVazio(enderecoModel.getBairro(), "O bairro é obrigatório!");
        ValidacaoUtils.validarVazio(enderecoModel.getLogradouro(), "O logradouro é obrigatório!");

        if (enderecoModel.getUsuario() == null) {
            throw new ParametroNullException("O Usuário deve ser informado!");
        }

        enderecoModel.setCep(enderecoModel.getCep().replace("-", ""));
        enderecoModel.setNumero(enderecoModel.getNumero()
                .replace("n", "")
                .replace("N", "")
                .replace(".", "")
                .replace("º", "")
                .replace(" ", ""));
    }

}
