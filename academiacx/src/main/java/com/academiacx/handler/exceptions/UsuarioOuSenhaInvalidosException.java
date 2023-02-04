package com.academiacx.handler.exceptions;

public class UsuarioOuSenhaInvalidosException extends RuntimeException {

    public UsuarioOuSenhaInvalidosException(String mensagem) {
        super(mensagem);
    }

    public UsuarioOuSenhaInvalidosException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
