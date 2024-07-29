package repository;

import model.ProjetoColaborativo;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class ProjetoColaborativoRepository {
    private Dao<ProjetoColaborativo, Integer> projetoColaborativoDao;

    public ProjetoColaborativoRepository(String databaseUrl) throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        projetoColaborativoDao = DaoManager.createDao(connectionSource, ProjetoColaborativo.class);
    }

    public void createProjetoColaborativo(ProjetoColaborativo projetoColaborativo) throws SQLException {
        projetoColaborativoDao.create(projetoColaborativo);
    }

    public ProjetoColaborativo getProjetoColaborativo(int id) throws SQLException {
        return projetoColaborativoDao.queryForId(id);
    }

    public void updateProjetoColaborativo(ProjetoColaborativo projetoColaborativo) throws SQLException {
        projetoColaborativoDao.update(projetoColaborativo);
    }

    public void deleteProjetoColaborativo(ProjetoColaborativo projetoColaborativo) throws SQLException {
        projetoColaborativoDao.delete(projetoColaborativo);
    }

    public List<ProjetoColaborativo> getAllProjetosColaborativos() throws SQLException {
        return projetoColaborativoDao.queryForAll();
    }

    public void close() throws Exception, SQLException {
        projetoColaborativoDao.getConnectionSource().close();
    }
}


