package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tarefas")
public class Tarefa {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String descricao;
    @DatabaseField
    private String prazo;

    public Tarefa() {
        // ORMLite requires a no-arg constructor
    }

    public Tarefa(String descricao, String prazo) {
        this.descricao = descricao;
        this.prazo = prazo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }
}

