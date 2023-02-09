package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.endereco.EnderecoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;


@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;


    public EnderecoModel() {

    }

    public EnderecoModel(EnderecoDto enderecoDto) {
        this.id = enderecoDto.getId();
        this.cep = enderecoDto.getCep();
        this.cidade = enderecoDto.getCidade();
        this.uf = enderecoDto.getUf();
        this.bairro = enderecoDto.getBairro();
        this.logradouro = enderecoDto.getLogradouro();
        this.numero = enderecoDto.getNumero();
    }
}
