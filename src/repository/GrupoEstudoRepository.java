package repository;

import model.GrupoEstudo;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class GrupoEstudoRepository {
    private Dao<GrupoEstudo, Integer> grupoEstudoDao;

    public GrupoEstudoRepository(String databaseUrl) throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        grupoEstudoDao = DaoManager.createDao(connectionSource, GrupoEstudo.class);
    }

    public void createGrupoEstudo(GrupoEstudo grupoEstudo) throws SQLException {
        grupoEstudoDao.create(grupoEstudo);
    }

    public GrupoEstudo getGrupoEstudo(int id) throws SQLException {
        return grupoEstudoDao.queryForId(id);
    }

    public void updateGrupoEstudo(GrupoEstudo grupoEstudo) throws SQLException {
        grupoEstudoDao.update(grupoEstudo);
    }

    public void deleteGrupoEstudo(GrupoEstudo grupoEstudo) throws SQLException {
        grupoEstudoDao.delete(grupoEstudo);
    }

    public List<GrupoEstudo> getAllGruposEstudo() throws SQLException {
        return grupoEstudoDao.queryForAll();
    }

    public void close() throws Exception, SQLException {
        grupoEstudoDao.getConnectionSource().close();
    }
}


