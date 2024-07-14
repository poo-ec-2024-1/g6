
package com.maria_dutra.estudocolaborativo.models;

import java.util.Date;

public class Tarefa {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataEntrega;
    private String status;
    private Aluno responsavel;

    public Tarefa() {}

    public Tarefa(Long id, String nome, String descricao, Date dataEntrega, String status, Aluno responsavel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.responsavel = responsavel;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Aluno responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Tarefa: " + nome + ", Status: " + status;
    }
}
