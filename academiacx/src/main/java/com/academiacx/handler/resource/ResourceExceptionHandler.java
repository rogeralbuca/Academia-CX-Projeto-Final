package com.academiacx.handler.resource;

import com.academiacx.handler.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(NumeroInvalidoException.class)
    public ResponseEntity<DetalhesErro> handlerNumeroInvalidoException(NumeroInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DetalhesErro(e.getMessage(), 400l, System.currentTimeMillis()));
    }

    @ExceptionHandler(UsuarioOuSenhaInvalidosException.class)
    public ResponseEntity<DetalhesErro> handlerUsuarioOuSenhaInvalidosException(UsuarioOuSenhaInvalidosException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetalhesErro(e.getMessage(), 404l, System.currentTimeMillis()));
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handlerUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetalhesErro(e.getMessage(), 404l, System.currentTimeMillis()));
    }

    @ExceptionHandler(ParametroNullException.class)
    public ResponseEntity<DetalhesErro> handlerParametroNullException(ParametroNullException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DetalhesErro(e.getMessage(), 400l, System.currentTimeMillis()));
    }

    @ExceptionHandler(CepInvalidoException.class)
    public ResponseEntity<DetalhesErro> handlerCepInvalidoException(CepInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DetalhesErro(e.getMessage(), 400l, System.currentTimeMillis()));
    }

    @ExceptionHandler(ErroAoAdicionarEnderecoException.class)
    public ResponseEntity<DetalhesErro> handlerErroAoAdicionarEnderecoException(ErroAoAdicionarEnderecoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new DetalhesErro(e.getMessage(), 422l, System.currentTimeMillis()));
    }


    @ExceptionHandler(TamanhoInvalidoException.class)
    public ResponseEntity<DetalhesErro> handlerTamanhoInvalidoException(TamanhoInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DetalhesErro(e.getMessage(), 400l, System.currentTimeMillis()));
    }

}