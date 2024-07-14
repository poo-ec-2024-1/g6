
package com.maria_dutra.estudocolaborativo.models;

import java.util.List;

public class Pergunta {
    private String texto;
    private List<String> opcoesResposta;

    public Pergunta() {
    }

    public Pergunta(String texto, List<String> opcoesResposta) {
        this.texto = texto;
        this.opcoesResposta = opcoesResposta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getOpcoesResposta() {
        return opcoesResposta;
    }

    public void setOpcoesResposta(List<String> opcoesResposta) {
        this.opcoesResposta = opcoesResposta;
    }

    public Object getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void setId(Long long1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
