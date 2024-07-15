package src;

import java.util.ArrayList;
import java.util.List;

// Classe Quiz
class Quiz {
    private List<String> perguntas = new ArrayList<>();
    private List<String> respostasCorretas = new ArrayList<>();

    public void adicionarPergunta(String pergunta, String resposta) {
        perguntas.add(pergunta);
        respostasCorretas.add(resposta);
    }

    public void removerPergunta(String pergunta) {
        int index = perguntas.indexOf(pergunta);
        if (index >= 0) {
            perguntas.remove(index);
            respostasCorretas.remove(index);
        }
    }

    public void realizarQuiz(List<String> respostas) {
        int pontuacao = 0;
        for (int i = 0; i < respostas.size(); i++) {
            if (respostas.get(i).equals(respostasCorretas.get(i))) {
                pontuacao++;
            }
        }
        System.out.println("Quiz realizado! Pontuação: " + pontuacao + "/" + perguntas.size());
    }
}