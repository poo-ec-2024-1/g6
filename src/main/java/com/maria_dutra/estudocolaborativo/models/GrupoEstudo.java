
package com.maria_dutra.estudocolaborativo.models;

import java.util.ArrayList;
import java.util.List;

public class GrupoEstudo {
    private Long id;
    private String nome;
    private List<Aluno> listaAlunos = new ArrayList<>();
    private List<Recurso> recursos = new ArrayList<>();

    public GrupoEstudo() {}

    public GrupoEstudo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void adicionarRecurso(Recurso recurso) {
        recursos.add(recurso);
    }
}
