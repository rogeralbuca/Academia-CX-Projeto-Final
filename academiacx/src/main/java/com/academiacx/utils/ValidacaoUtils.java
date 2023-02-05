package com.academiacx.utils;

import com.academiacx.handler.exceptions.CepInvalidoException;
import com.academiacx.handler.exceptions.NumeroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.TamanhoInvalidoException;

public interface ValidacaoUtils {

    static void validarVazio(String valor, String errorMessage) {
        if (valor == null || valor.isEmpty() || valor.isBlank()) {
            throw new ParametroNullException(errorMessage);
        }
    }

    static void validarCep(String cep, String errorMessage) {

        validarVazio(cep, errorMessage);

        if (!cep.matches("\\d{5}-?\\d{3}")) {
            throw new CepInvalidoException(errorMessage);
        }
    }

    static void validarNumeroEndereco(String numero, String errorMessage) {

        validarVazio(numero, errorMessage);

        if (!numero.matches("[Nn]?\\.?\\s?º?\\s?\\d+")) {
            throw new NumeroInvalidoException(errorMessage);
        }
    }

    static void validarRangeTamanho(String valor, int tamanhoMinimo, int tamanhoMaximo, String errorMessage) {

        validarVazio(valor, errorMessage);

        if (valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
            throw new TamanhoInvalidoException(errorMessage);
        }
    }
}
