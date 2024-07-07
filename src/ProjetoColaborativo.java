package src;
import java.util.Date;

public class ProjetoColaborativo extends Projeto implements Colaboracao {

    public ProjetoColaborativo(String nome, String descricao, Date dataInicio, Date dataFim) {
        super(nome, descricao, dataInicio, dataFim);
    }

    @Override
    public void comentar(String comentario) {
        System.out.println("Comentário adicionado: " + comentario);
    }

    @Override
    public void adicionarArquivo(String arquivo) {
        System.out.println("Arquivo adicionado: " + arquivo);
    }
}

