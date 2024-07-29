package repository;

import model.Tarefa;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class TarefaRepository {
    private Dao<Tarefa, Integer> tarefaDao;

    public TarefaRepository(String databaseUrl) throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        tarefaDao = DaoManager.createDao(connectionSource, Tarefa.class);
    }

    public void createTarefa(Tarefa tarefa) throws SQLException {
        tarefaDao.create(tarefa);
    }

    public Tarefa getTarefa(int id) throws SQLException {
        return tarefaDao.queryForId(id);
    }

    public void updateTarefa(Tarefa tarefa) throws SQLException {
        tarefaDao.update(tarefa);
    }

    public void deleteTarefa(Tarefa tarefa) throws SQLException {
        tarefaDao.delete(tarefa);
    }

    public List<Tarefa> getAllTarefas() throws SQLException {
        return tarefaDao.queryForAll();
    }

    public void close() throws Exception, SQLException {
        tarefaDao.getConnectionSource().close();
    }
}


