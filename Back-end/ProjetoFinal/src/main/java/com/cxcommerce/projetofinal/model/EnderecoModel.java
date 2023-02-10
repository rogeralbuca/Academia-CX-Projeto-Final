package com.cxcommerce.projetofinal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Collection;

@Entity
@Table(name="endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonProperty("cep")
    private String cep;

    @NotNull
    @JsonProperty("username")
    private String nome;

    @NotNull
    @JsonProperty("rua")
    private String rua;

    @NotNull
    @JsonProperty("bairro")
    private String bairro;


    @NotNull
    @JsonProperty("cidade")
    private String cidade;


    @NotNull
    @JsonProperty("estado")
    @Size(min = 0, max = 2)
    private String estado;

    @NotNull
    @JsonProperty("numero")
    private int numero;

    public EnderecoModel(Long id, String cep, String nome, String rua, String bairro, String cidade, String estado, int numero) {
        this.id = id;
        this.cep = cep;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public EnderecoModel() {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}
