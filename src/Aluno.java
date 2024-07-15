package src;

import java.util.List;

// Classe Aluno
class Aluno extends Usuario {
    private String curso;
    private double matricula;
    private String pais;

    public Aluno(String nome, String email, String senha, String curso, double matricula, String pais) {
        super(nome, email, senha);
        this.curso = curso;
        this.matricula = matricula;
        this.pais = pais;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void participarGrupo(GrupoEstudo grupo) {
        if (isLogado()) {
            grupo.adicionarAluno(this);
            System.out.println("Aluno " + this.matricula + " participou do grupo " + grupo.getNome());
        } else {
            System.out.println("Aluno não está logado!");
        }
    }

    public void compartilharRecurso(GrupoEstudo grupo, Recurso recurso) {
        if (isLogado()) {
            grupo.adicionarRecurso(recurso);
            System.out.println("Recurso compartilhado no grupo " + grupo.getNome());
        } else {
            System.out.println("Aluno não está logado!");
        }
    }

    public void responderQuiz(Quiz quiz, List<String> respostas) {
        if (isLogado()) {
            quiz.realizarQuiz(respostas);
        } else {
            System.out.println("Aluno não está logado!");
        }
    }
}
