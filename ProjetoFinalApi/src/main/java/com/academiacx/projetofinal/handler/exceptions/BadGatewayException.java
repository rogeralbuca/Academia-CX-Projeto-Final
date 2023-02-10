package com.academiacx.projetofinal.handler.exceptions;

public class BadGatewayException extends RuntimeException{

    public BadGatewayException(String mensagem){
        super(mensagem);
    }

    public BadGatewayException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
