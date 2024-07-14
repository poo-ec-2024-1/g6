
package com.maria_dutra.estudocolaborativo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjetoColaborativo extends Projeto implements Colaboração {
    private List<String> comentarios;
    private List<String> arquivos;

    public ProjetoColaborativo() {
        super();
        this.comentarios = new ArrayList<>();
        this.arquivos = new ArrayList<>();
    }

    public ProjetoColaborativo(double id,String nome, String descricao, Date dataInicio, Date dataFim) {
        super(id, nome, descricao, dataInicio, dataFim);
        this.comentarios = new ArrayList<>();
        this.arquivos = new ArrayList<>();
    }

    @Override
    public void comentar(String comentario) {
        comentarios.add(comentario);
    }

    @Override
    public void adicionarArquivo(String arquivo) {
        arquivos.add(arquivo);
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public List<String> getArquivos() {
        return arquivos;
    }
}
