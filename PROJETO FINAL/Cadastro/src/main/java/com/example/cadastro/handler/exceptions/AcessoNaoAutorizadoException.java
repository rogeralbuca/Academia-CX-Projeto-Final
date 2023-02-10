package com.example.cadastro.handler.exceptions;

public class AcessoNaoAutorizadoException extends RuntimeException {

    public AcessoNaoAutorizadoException(String mensagem){
        super(mensagem);
    }

    public AcessoNaoAutorizadoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
