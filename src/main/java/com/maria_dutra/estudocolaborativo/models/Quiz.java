package com.maria_dutra.estudocolaborativo.models;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private Long id;
    private String titulo;
    private String descricao;
    private List<Pergunta> perguntas;

    public Quiz() {
        this.perguntas = new ArrayList<>();
    }

    public Quiz(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.perguntas = new ArrayList<>();
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public void adicionarPergunta(Pergunta pergunta) {
        this.perguntas.add(pergunta);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", perguntas=" + perguntas +
                '}';
    }
}