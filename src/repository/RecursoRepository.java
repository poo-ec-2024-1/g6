package repository;

import model.Recurso;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class RecursoRepository {
    private Dao<Recurso, Integer> recursoDao;

    public RecursoRepository(String databaseUrl) throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        recursoDao = DaoManager.createDao(connectionSource, Recurso.class);
    }

    public void createRecurso(Recurso recurso) throws SQLException {
        recursoDao.create(recurso);
    }

    public Recurso getRecurso(int id) throws SQLException {
        return recursoDao.queryForId(id);
    }

    public void updateRecurso(Recurso recurso) throws SQLException {
        recursoDao.update(recurso);
    }

    public void deleteRecurso(Recurso recurso) throws SQLException {
        recursoDao.delete(recurso);
    }

    public List<Recurso> getAllRecursos() throws SQLException {
        return recursoDao.queryForAll();
    }

    public void close() throws Exception, SQLException {
        recursoDao.getConnectionSource().close();
    }
}

