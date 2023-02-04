package com.academiacx.handler.exceptions;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DetalhesErro {

    private String campo;
    private String titulo;
    private Long status;
    private Long timestamp;


    public DetalhesErro() {

    }

    public DetalhesErro(String titulo, Long status, Long timestamp) {
        this.titulo = titulo;
        this.status = status;
        this.timestamp = timestamp;
    }

    public DetalhesErro(String titulo, Long status, Long timestamp, String campo) {
        this.titulo = titulo;
        this.status = status;
        this.timestamp = timestamp;
        this.campo = campo;
    }


    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
