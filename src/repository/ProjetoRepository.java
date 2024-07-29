package repository;

import model.Projeto;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class ProjetoRepository {
    private Dao<Projeto, Integer> projetoDao;

    public ProjetoRepository(String databaseUrl) throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        projetoDao = DaoManager.createDao(connectionSource, Projeto.class);
    }

    public void createProjeto(Projeto projeto) throws SQLException {
        projetoDao.create(projeto);
    }

    public Projeto getProjeto(int id) throws SQLException {
        return projetoDao.queryForId(id);
    }

    public void updateProjeto(Projeto projeto) throws SQLException {
        projetoDao.update(projeto);
    }

    public void deleteProjeto(Projeto projeto) throws SQLException {
        projetoDao.delete(projeto);
    }

    public List<Projeto> getAllProjetos() throws SQLException {
        return projetoDao.queryForAll();
    }

    public void close() throws Exception, SQLException {
        projetoDao.getConnectionSource().close();
    }
}

