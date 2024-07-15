package src;

import java.util.ArrayList;
import java.util.List;

class GrupoEstudo {
    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
    private List<Recurso> recursos = new ArrayList<>();

    public GrupoEstudo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado ao grupo " + nome);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
        System.out.println("Aluno removido do grupo " + nome);
    }

    public void adicionarRecurso(Recurso recurso) {
        recursos.add(recurso);
        System.out.println("Recurso adicionado ao grupo " + nome);
    }

    public void visualizarRecursos() {
        System.out.println("Recursos do grupo " + nome + ":");
        for (Recurso recurso : recursos) {
            recurso.visualizar();
        }
    }
}