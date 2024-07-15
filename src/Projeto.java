package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Projeto
class Projeto {
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Projeto(String nome, String descricao, Date dataInicio, Date dataFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
        System.out.println("Tarefa " + tarefa.getNome() + " adicionada ao projeto " + nome);
    }

    public void removerTarefa(Tarefa tarefa) {
        listaTarefas.remove(tarefa);
        System.out.println("Tarefa " + tarefa.getNome() + " removida do projeto " + nome);
    }

    public void listarTarefas() {
        System.out.println("Tarefas do projeto " + nome + ":");
        for (Tarefa tarefa : listaTarefas) {
            tarefa.visualizar();
        }
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
        System.out.println("Aluno adicionado ao projeto " + nome);
    }

    public void visualizarProjeto() {
        System.out.println("Projeto: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Data de Fim: " + dataFim);
        listarTarefas();
    }
}
