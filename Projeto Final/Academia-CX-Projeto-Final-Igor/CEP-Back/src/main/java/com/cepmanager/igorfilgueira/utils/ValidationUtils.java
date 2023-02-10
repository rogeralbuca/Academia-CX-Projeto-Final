package com.cepmanager.igorfilgueira.utils;


import com.cepmanager.igorfilgueira.handler.exceptions.ParametroInvalidoException;

public interface ValidationUtils {


    static void validateNotNullOrEmpty(String teste, String warning){
        if (teste.isBlank() || teste == null || teste.isEmpty()){
            throw new ParametroInvalidoException(warning);
        }
    }



}
