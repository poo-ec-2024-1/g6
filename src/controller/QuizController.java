package controller;

import model.Quiz;
import repository.QuizRepository;
import java.sql.SQLException;
import java.util.List;

public class QuizController {
    private QuizRepository quizRepository;

    public QuizController(String databaseUrl) throws SQLException {
        quizRepository = new QuizRepository(databaseUrl);
    }

    public void adicionarQuiz(Quiz quiz) throws SQLException {
        quizRepository.createQuiz(quiz);
    }

    public Quiz obterQuiz(int id) throws SQLException {
        return quizRepository.getQuiz(id);
    }

    public void atualizarQuiz(Quiz quiz) throws SQLException {
        quizRepository.updateQuiz(quiz);
    }

    public void removerQuiz(Quiz quiz) throws SQLException {
        quizRepository.deleteQuiz(quiz);
    }

    public List<Quiz> listarQuizzes() throws SQLException {
        return quizRepository.getAllQuizzes();
    }

    public void fecharConexao() throws Exception, SQLException {
        quizRepository.close();
    }
}

