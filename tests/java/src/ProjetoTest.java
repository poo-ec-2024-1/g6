package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class ProjetoTest {

    @Test
    public void testAdicionarTarefa() {
        Projeto projeto = new Projeto("Projeto de Física", "Construção de um foguete", new Date(), new Date());
        Aluno aluno = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        Tarefa tarefa = new Tarefa("Montagem", "Montar o foguete", new Date(), aluno);
        
        projeto.adicionarTarefa(tarefa);
        
        assertTrue(projeto.getListaTarefas().contains(tarefa));
    }
    
    @Test
    public void testAdicionarAluno() {
        Projeto projeto = new Projeto("Projeto de Física", "Construção de um foguete", new Date(), new Date());
        Aluno aluno = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        
        projeto.adicionarAluno(aluno);
        
        assertTrue(projeto.getListaAlunos().contains(aluno));
    }
}