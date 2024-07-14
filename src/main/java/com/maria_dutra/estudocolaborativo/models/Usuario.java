package com.maria_dutra.estudocolaborativo.models;

public class Usuario {

    private long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {}

    //Contrutor
    public Usuario(Long id, String nome , String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

    }

    //getter e setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void getSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email;
    }
}

    
