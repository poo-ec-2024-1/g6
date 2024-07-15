package src;

import java.util.Date;

// Classe ProjetoColaborativo
class ProjetoColaborativo extends Projeto implements Colaboracao {
    public ProjetoColaborativo(String nome, String descricao, Date dataInicio, Date dataFim) {
        super(nome, descricao, dataInicio, dataFim);
    }

    @Override
    public void comentar(String comentario) {
        // Lógica para adicionar comentário
        System.out.println("Comentário adicionado: " + comentario);
    }

    @Override
    public void adicionarArquivo(String arquivo) {
        // Lógica para adicionar arquivo
        System.out.println("Arquivo adicionado: " + arquivo);
    }

    public void comecar() {
        // Lógica para começar o projeto colaborativo
        System.out.println("Projeto colaborativo " + getNome() + " iniciado.");
    }
}
