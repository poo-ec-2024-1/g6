package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class QuizTest {

    @Test
    public void testAdicionarPergunta() {
        Quiz quiz = new Quiz();
        quiz.adicionarPergunta("Qual é a diferença entre equals() e ==?", "Primeiro, “ ==” é um operador enquanto equals() é um método");
        
        // Verifique se a pergunta foi adicionada corretamente
    }
    
    @Test
    public void testRemoverPergunta() {
        Quiz quiz = new Quiz();
        quiz.adicionarPergunta("Qual é a diferença entre equals() e ==?", "Primeiro, “ ==” é um operador enquanto equals() é um método");
        quiz.removerPergunta("Qual é a diferença entre equals() e ==?");
        
        // Verifique se a pergunta foi removida corretamente
    }
    
    @Test
    public void testRealizarQuiz() {
        Quiz quiz = new Quiz();
        quiz.adicionarPergunta("Qual é a diferença entre equals() e ==?", "Primeiro, “ ==” é um operador enquanto equals() é um método");
        
        List<String> respostas = new ArrayList<>();
        respostas.add("Primeiro, “ ==” é um operador enquanto equals() é um método");
        
        quiz.realizarQuiz(respostas);
        
        // Verifique o comportamento esperado após a realização do quiz
    }
}