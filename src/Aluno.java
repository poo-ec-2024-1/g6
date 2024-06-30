package src;
public class Aluno extends Usuario {
    private String curso;
    private String matricula;

    public Aluno(String nome, String email, String curso, String matricula, String país) {
        super(nome, email,país);
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }
}

