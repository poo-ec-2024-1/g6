
package com.maria_dutra.estudocolaborativo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Projeto() {}

    public Projeto(Long id, String nome, String descricao, Date dataInicio, Date dataFim) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Projeto(double id2, String nome2, String descricao2, Date dataInicio2, Date dataFim2) {
        
    }

    // Getters e Setters
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }
}

