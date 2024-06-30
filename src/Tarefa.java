package src;
import java.util.Date;

public class Tarefa {
    private String nome;
    private String descricao;
    private Date dataEntrega;
    private String status;
    private Aluno responsavel;

    public Tarefa(String nome, String descricao, Date dataEntrega, String status, Aluno responsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public Aluno getResponsavel() {
        return responsavel;
    }
}

