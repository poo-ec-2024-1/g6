
package com.maria_dutra.estudocolaborativo.models;

public class Recurso {
    private Long id;
    private String titulo;
    private String tipo;
    private String conteudo;

    public Recurso() {}

    public Recurso(Long id, String titulo, String tipo, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Recurso: " + titulo + ", Tipo: " + tipo;
    }
}
