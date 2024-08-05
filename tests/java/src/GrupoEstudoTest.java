package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrupoEstudoTest {

    @Test
    public void testAdicionarAluno() {
        GrupoEstudo grupo = new GrupoEstudo("Grupo de POO");
        Aluno aluno = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        
        grupo.adicionarAluno(aluno);
        
        assertTrue(grupo.getAlunos().contains(aluno));
    }

    @Test
    public void testAdicionarRecurso() {
        GrupoEstudo grupo = new GrupoEstudo("Grupo de POO");
        Recurso recurso = new Recurso("Apostila de Java", "PDF", "Conteúdo da apostila");
        
        grupo.adicionarRecurso(recurso);
        
        assertTrue(grupo.getRecursos().contains(recurso));
    }
}