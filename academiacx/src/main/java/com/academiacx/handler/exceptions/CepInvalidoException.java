package com.academiacx.handler.exceptions;

public class CepInvalidoException extends RuntimeException {

    public CepInvalidoException(String mensagem) {
        super(mensagem);
    }

    public CepInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
