package controller;

import model.Recurso;
import repository.RecursoRepository;
import java.sql.SQLException;
import java.util.List;

public class RecursoController {
    private RecursoRepository recursoRepository;

    public RecursoController(String databaseUrl) throws SQLException {
        recursoRepository = new RecursoRepository(databaseUrl);
    }

    public void adicionarRecurso(Recurso recurso) throws SQLException {
        recursoRepository.createRecurso(recurso);
    }

    public Recurso obterRecurso(int id) throws SQLException {
        return recursoRepository.getRecurso(id);
    }

    public void atualizarRecurso(Recurso recurso) throws SQLException {
        recursoRepository.updateRecurso(recurso);
    }

    public void removerRecurso(Recurso recurso) throws SQLException {
        recursoRepository.deleteRecurso(recurso);
    }

    public List<Recurso> listarRecursos() throws SQLException {
        return recursoRepository.getAllRecursos();
    }

    public void fecharConexao() throws Exception, SQLException {
        recursoRepository.close();
    }
}

