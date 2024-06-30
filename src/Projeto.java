import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private List<Tarefa> listaTarefas;
    private List<Aluno> listaAlunos;

    public Projeto(String nome, String descricao, Date dataInicio, Date dataFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.listaTarefas = new ArrayList<>();
        this.listaAlunos = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }
}

