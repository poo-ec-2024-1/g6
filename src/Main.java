package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Maria", "maria@example.com", "senha123", "Engenharia", 12345, "Brasil");
        aluno1.login("maria@example.com", "senha123");

        GrupoEstudo grupo1 = new GrupoEstudo("Grupo de POO");
        aluno1.participarGrupo(grupo1);

        Recurso recurso1 = new Recurso("Apostila de Java", "PDF", "Conteúdo da apostila");
        aluno1.compartilharRecurso(grupo1, recurso1);

        Quiz quiz1 = new Quiz();
        quiz1.adicionarPergunta("Qual é a diferença entre equals()e ==?", "Primeiro, “ ==” é um operador enquanto equals()é um método");
        List<String> respostas = new ArrayList<>();
        respostas.add("Primeiro, “ ==” é um operador enquanto equals()é um método");
        aluno1.responderQuiz(quiz1, respostas);

        Projeto projeto1 = new Projeto("Projeto de Física", "Construção de um foguete", new Date(), new Date());
        aluno1.participarGrupo(grupo1);  // Usar o método participarGrupo para simular o aluno no projeto
        Tarefa tarefa1 = new Tarefa("Montagem", "Montar o foguete", new Date(), aluno1);
        projeto1.adicionarTarefa(tarefa1);

        ProjetoColaborativo projetoColab1 = new ProjetoColaborativo("Projeto Colaborativo", "Desenvolvimento de software", new Date(), new Date());
        projetoColab1.comentar("Primeiro comentário do projeto.");
        projetoColab1.adicionarArquivo("documento.txt");
        projetoColab1.comecar();

        projeto1.visualizarProjeto();
    }
}
