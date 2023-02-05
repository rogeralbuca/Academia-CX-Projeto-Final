package com.academiacx.service;

import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.handler.exceptions.UsuarioOuSenhaInvalidosException;
import com.academiacx.model.UsuarioModel;
import com.academiacx.repository.UsuarioRepository;
import com.academiacx.security.HashFunction;
import com.academiacx.utils.ValidacaoUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioModel findByUsernameAndPassword(UsuarioModel usuario) {

        ValidacaoUtils.validarVazio(usuario.getUsername(), "O username é obrigatório!");
        ValidacaoUtils.validarVazio(usuario.getPassword(), "A senha é obrigatória!");

        if (usuarioRepository.findByUsername(usuario.getUsername()).isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuário " + usuario.getUsername() + " não encontrado!");
        }

        Optional<UsuarioModel> usuarioModel = usuarioRepository.findByUsernameAndPassword(usuario.getUsername(),
                                                                                          HashFunction.getHash(usuario.getPassword()));

        if (usuarioModel.isEmpty()) {
            throw new UsuarioOuSenhaInvalidosException("Usuário ou senha inválidos!");
        }

        return usuarioModel.get();
    }
}
