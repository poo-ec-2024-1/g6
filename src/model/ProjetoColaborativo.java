package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "projetos_colaborativos")
public class ProjetoColaborativo extends Projeto implements Colaboracao {
    @DatabaseField
    private String objetivo;

    public ProjetoColaborativo() {
        // ORMLite requires a no-arg constructor
    }

    public ProjetoColaborativo(String nome, String descricao, String objetivo) {
        super(nome, descricao);
        this.objetivo = objetivo;
    }

    // Getters e Setters
    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public void colaborar() {
        // Lógica para colaboração
    }
}
