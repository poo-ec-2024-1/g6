import java.util.Date;

public class ProjetoColaborativo extends Projeto implements Colaboracao {

    public ProjetoColaborativo(String nome, String descricao, Date dataInicio, Date dataFim) {
        super(nome, descricao, dataInicio, dataFim);
    }

    @Override
    public void comentar(String comentario) {
        // Implemente o código para comentar no projeto colaborativo
        System.out.println("Comentário adicionado: " + comentario);
    }

    @Override
    public void adicionarArquivo(String arquivo) {
        // Implemente o código para adicionar arquivo no projeto colaborativo
        System.out.println("Arquivo adicionado: " + arquivo);
    }
}

