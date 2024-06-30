package src;
import java.util.List;

public class Quiz {
    private List<String> perguntas;
    private List<String> respostas;

    public Quiz(List<String> perguntas, List<String> respostas) {
        this.perguntas = perguntas;
        this.respostas = respostas;
    }

    public List<String> getPerguntas() {
        return perguntas;
    }

    public List<String> getRespostas() {
        return respostas;
    }
}
