package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.EnderecoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    public EnderecoModel() {
    }

    public EnderecoModel(EnderecoDto enderecoDto) {
        this.id = enderecoDto.getId();
        this.cep = enderecoDto.getCep();
        this.rua = enderecoDto.getRua();
        this.bairro = enderecoDto.getBairro();
        this.cidade = enderecoDto.getCidade();
        this.estado = enderecoDto.getEstado();
        this.numero = enderecoDto.getNumero();
        this.cliente = enderecoDto.getCliente();
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
