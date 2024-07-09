import java.util.ArrayList;
import java.util.List;

public class GrupoEstudo {
    private String nome;
    private List<Aluno> listaAlunos;
    private List<Recurso> recursos;

    public GrupoEstudo(String nome) {
        this.nome = nome;
        this.listaAlunos = new ArrayList<>();
        this.recursos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void adicionarRecurso(Recurso recurso) {
        recursos.add(recurso);
    }
}
