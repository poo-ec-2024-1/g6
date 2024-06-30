public class Aluno extends Usuario {
    private String curso;
    private String matricula;

    public Aluno(String nome, String email, String curso, String matricula) {
        super(nome, email);
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

