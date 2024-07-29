package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "grupos_estudo")
public class GrupoEstudo {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nome;

    public GrupoEstudo() {
        // ORMLite requires a no-arg constructor
    }

    public GrupoEstudo(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarAluno(Aluno aluno) {
        // Lógica para adicionar um aluno ao grupo
    }

    public void adicionarRecurso(Recurso recurso) {
        // Lógica para adicionar um recurso ao grupo
    }
}

