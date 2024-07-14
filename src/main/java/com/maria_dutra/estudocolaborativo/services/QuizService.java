package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.Quiz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private List<Quiz> quizzes = new ArrayList<>();
    private Long nextId = 1L;

    public List<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public Quiz getQuizById(Long id) {
        Optional<Quiz> quizOptional = quizzes.stream().filter(q -> q.getId().equals(id)).findFirst();
        return quizOptional.orElse(null);
    }

    public Quiz addQuiz(Quiz quiz) {
        quiz.setId(nextId++);
        quizzes.add(quiz);
        return quiz;
    }

    public void deleteQuiz(Long id) {
        quizzes.removeIf(q -> q.getId().equals(id));
    }
}
