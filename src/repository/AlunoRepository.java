package repository;

import model.Aluno;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class AlunoRepository {
    private Dao<Aluno, Integer> alunoDao;

    public AlunoRepository(String databaseUrl) throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        alunoDao = DaoManager.createDao(connectionSource, Aluno.class);
    }

    public void createAluno(Aluno aluno) throws SQLException {
        alunoDao.create(aluno);
    }

    public Aluno getAluno(int id) throws SQLException {
        return alunoDao.queryForId(id);
    }

    public void updateAluno(Aluno aluno) throws SQLException {
        alunoDao.update(aluno);
    }

    public void deleteAluno(Aluno aluno) throws SQLException {
        alunoDao.delete(aluno);
    }

    public List<Aluno> getAllAlunos() throws SQLException {
        return alunoDao.queryForAll();
    }

    public void close() throws Exception, SQLException {
        alunoDao.getConnectionSource().close();
    }
}



