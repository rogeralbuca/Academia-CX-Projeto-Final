package com.demo.academiacx.utils;


import com.demo.academiacx.handler.ParametroInvalidoException;
import io.micrometer.common.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidacaoUtils {

    static void validarNumerico(String valor, String errorMsg){
        if (valor == null){
            return;
        }

        try {
            new BigInteger(valor);

        } catch (NumberFormatException e){
            throw new ParametroInvalidoException(errorMsg);
        }
    }

    static void validarTamanhoMinino(String valor, int tamanhoMinimo, String errorMsg){
        if (tamanhoMinimo == 0){
            return;
        }

        if (valor == null || valor.length() < tamanhoMinimo){
            throw new ParametroInvalidoException(errorMsg);
        }
    }

    static void validarTamanhoMaximo(String valor, int tamanhoMaximo, String errorMsg){
        if (valor != null && valor.length() > tamanhoMaximo){
            throw new ParametroInvalidoException(errorMsg);
        }
    }

    static void validarTamanhoMinimoMaximo(String valor, int tamanhoMinimo, int tamanhoMaximo, String errorMsg){

        if(valor == null || valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo){
            throw new ParametroInvalidoException(errorMsg);
        }
    }

    static void validarNaoVazio(String valor, String msg){
        if (valor == null || StringUtils.isBlank(valor)){
            throw new ParametroInvalidoException(msg);
        }
    }

    static void valorVazio(String valor, String msg){
        if(valor == null || valor.isEmpty()){
            throw new ParametroInvalidoException(msg);
        }
    }

    static void idNaoNula(Long valor, String msg){
        if(valor == null){
            throw new ParametroInvalidoException(msg);
        }
    }


    // REGEX
    static void passwordValidation(String password, String msg){

        valorVazio(password, msg);

        // Senha de 8 a 16 caracteres com pelo menos um dígito, pelo menos um
        // letra minúscula, pelo menos uma letra maiúscula, pelo menos uma
        // caractere especial sem espaços em branco
        String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

        Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        if(!matcher.matches()){
            throw new ParametroInvalidoException(msg);
        }
    }

    static void cepValidation(String cep, String msg){

        valorVazio(cep, msg);

        String CEP_REGEX = "(^[0-9]{5})-?([0-9]{3}$)";

        Pattern CEP_PATTERN = Pattern.compile(CEP_REGEX);

        Matcher matcher = CEP_PATTERN.matcher(cep);

        if(!matcher.matches()){
            throw new ParametroInvalidoException(msg);
        }
    }




}

