package com.academiacx.handler.exceptions;

public class ErroAoAdicionarEnderecoException extends RuntimeException {

    public ErroAoAdicionarEnderecoException(String mensagem) {
        super(mensagem);
    }

    public ErroAoAdicionarEnderecoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}



