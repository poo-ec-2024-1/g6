package repository;

import model.Usuario;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;

public class UsuarioRepository {
    private Dao<Usuario, Integer> usuarioDao;

    public UsuarioRepository(String databaseUrl) throws SQLException {
        // Cria a conexão com o banco de dados
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        // Cria o DAO para a entidade Usuario
        usuarioDao = DaoManager.createDao(connectionSource, Usuario.class);
    }

    // Método para criar um novo Usuario no banco de dados
    public void createUsuario(Usuario usuario) throws SQLException {
        usuarioDao.create(usuario);
    }

    // Método para buscar um Usuario por ID
    public Usuario getUsuario(int id) throws SQLException {
        return usuarioDao.queryForId(id);
    }

    // Método para atualizar um Usuario existente
    public void updateUsuario(Usuario usuario) throws SQLException {
        usuarioDao.update(usuario);
    }

    // Método para deletar um Usuario
    public void deleteUsuario(Usuario usuario) throws SQLException {
        usuarioDao.delete(usuario);
    }

    // Método para fechar a conexão com o banco de dados
    public void close() throws Exception, SQLException {
        usuarioDao.getConnectionSource().close();
    }
}

