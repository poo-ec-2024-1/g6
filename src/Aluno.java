package src;
public class Aluno extends Usuario {
    private String curso;
    private int matricula;

    public Aluno(String nome, String email, String curso, int matricula, String país) {
        super(nome, email,país);
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public int getMatricula() {
        return matricula;
    }
}

