package src;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Maria", "maria@example.com", "Engenheria da computação", 123456 ,"Brasil");
        Aluno aluno2 = new Aluno("Andreia", "Andreia@example.com", "Medicina", 654789 , "EUA");
        
        GrupoEstudo grupo = new GrupoEstudo("Grupo de estudo de POO");
        grupo.adicionarAluno(aluno1);
        grupo.adicionarAluno(aluno2);

        Recurso recurso1 = new Recurso("Livro de Java", "Livro", "Conteúdo de Progamação");
        grupo.adicionarRecurso(recurso1);

        Quiz quiz = new Quiz(
            Arrays.asList("Pergunta 1", "Pergunta 2"),
            Arrays.asList("Resposta 1", "Resposta 2")
        );

        Projeto projeto = new Projeto("Projeto X", "Descrição do Projeto X", new Date(), new Date());
        projeto.adicionarAluno(aluno1);

        Tarefa tarefa = new Tarefa("Tarefa 1", "Descrição da Tarefa 1", new Date(), "Pendente", aluno1);
        projeto.adicionarTarefa(tarefa);

        ProjetoColaborativo projetoColaborativo = new ProjetoColaborativo("Projeto Colaborativo Y", "Descrição do Projeto Y", new Date(), new Date());
        projetoColaborativo.comentar("Este é um comentário no projeto colaborativo.");
        projetoColaborativo.adicionarArquivo("arquivo.pdf");
    }
    
}
