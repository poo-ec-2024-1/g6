
package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.Quiz;
import com.maria_dutra.estudocolaborativo.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }
}
