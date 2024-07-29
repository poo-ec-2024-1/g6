package repository;

import model.Quiz;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class QuizRepository {
    private Dao<Quiz, Integer> quizDao;

    public QuizRepository(String databaseUrl) throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        quizDao = DaoManager.createDao(connectionSource, Quiz.class);
    }

    public void createQuiz(Quiz quiz) throws SQLException {
        quizDao.create(quiz);
    }

    public Quiz getQuiz(int id) throws SQLException {
        return quizDao.queryForId(id);
    }

    public void updateQuiz(Quiz quiz) throws SQLException {
        quizDao.update(quiz);
    }

    public void deleteQuiz(Quiz quiz) throws SQLException {
        quizDao.delete(quiz);
    }

    public List<Quiz> getAllQuizzes() throws SQLException {
        return quizDao.queryForAll();
    }

    public void close() throws Exception, SQLException {
        quizDao.getConnectionSource().close();
    }
}
