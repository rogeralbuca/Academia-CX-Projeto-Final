package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.EnderecoModel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EnderecoDto {

    private Long id;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;
    private ClienteModel cliente;

    public EnderecoDto() {
    }

    public EnderecoDto(EnderecoModel enderecoModel) {
        this.id = enderecoModel.getId();
        this.cep = enderecoModel.getCep();
        this.rua = enderecoModel.getRua();
        this.bairro = enderecoModel.getBairro();
        this.cidade = enderecoModel.getCidade();
        this.estado = enderecoModel.getEstado();
        this.numero = enderecoModel.getNumero();
        this.cliente = enderecoModel.getCliente();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
