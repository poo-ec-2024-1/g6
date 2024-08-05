package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AlunoTest {

    @Test
    public void testParticiparGrupo() {
        Aluno aluno = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        GrupoEstudo grupo = new GrupoEstudo("Grupo de POO");
        
        aluno.login("maria@example.com", "senha123");
        aluno.participarGrupo(grupo);
        
        assertTrue(grupo.getAlunos().contains(aluno));
    }

    @Test
    public void testCompartilharRecurso() {
        Aluno aluno = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        GrupoEstudo grupo = new GrupoEstudo("Grupo de POO");
        Recurso recurso = new Recurso("Apostila de Java", "PDF", "Conteúdo da apostila");
        
        aluno.login("maria@example.com", "senha123");
        aluno.compartilharRecurso(grupo, recurso);
        
        assertTrue(grupo.getRecursos().contains(recurso));
    }

    @Test
    public void testResponderQuiz() {
        Aluno aluno = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        Quiz quiz = new Quiz();
        quiz.adicionarPergunta("Qual é a diferença entre equals() e ==?", "Primeiro, “ ==” é um operador enquanto equals() é um método");
        
        List<String> respostas = new ArrayList<>();
        respostas.add("Primeiro, “ ==” é um operador enquanto equals() é um método");
        
        aluno.login("maria@example.com", "senha123");
        aluno.responderQuiz(quiz, respostas);
        
        // Verifique o comportamento esperado após a resposta do quiz
    }
}