package src;

import java.util.Date;

// Classe Tarefa
class Tarefa {
    private String nome;
    private String descricao;
    private Date dataEntrega;
    private Aluno responsavel;

    public Tarefa(String nome, String descricao, Date dataEntrega, Aluno responsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void visualizar() {
        System.out.println("Tarefa: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Entrega: " + dataEntrega);
        System.out.println("Responsável: " + responsavel);
    }

    public void atualizarStatus(String status) {
        // Lógica para atualizar o status da tarefa
        System.out.println("Status da tarefa " + nome + " atualizado para: " + status);
    }

    public void definirResponsavel(Aluno responsavel) {
        this.responsavel = responsavel;
        System.out.println("Responsável pela tarefa " + nome + " definido para: " + responsavel);
    }
}