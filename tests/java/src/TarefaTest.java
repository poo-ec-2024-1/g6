package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class TarefaTest {

    @Test
    public void testVisualizar() {
        Aluno aluno = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        Tarefa tarefa = new Tarefa("Montagem", "Montar o foguete", new Date(), aluno);
        
        tarefa.visualizar();
        
        // Certifique-se de que os atributos estão corretos
        assertEquals("Montagem", tarefa.getNome());
        assertEquals("Montar o foguete", tarefa.getDescricao());
        assertEquals(aluno, tarefa.getResponsavel());
    }
}