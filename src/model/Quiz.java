package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "quizzes")
public class Quiz {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String titulo;
    // Outros campos relevantes para o quiz

    public Quiz() {
        // ORMLite requires a no-arg constructor
    }

    public Quiz(String titulo) {
        this.titulo = titulo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void realizarQuiz(List<String> respostas) {
        // Lógica para realizar o quiz
    }
}
