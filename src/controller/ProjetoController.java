package controller;

import model.Projeto;
import repository.ProjetoRepository;
import java.sql.SQLException;
import java.util.List;

public class ProjetoController {
    private ProjetoRepository projetoRepository;

    public ProjetoController(String databaseUrl) throws SQLException {
        projetoRepository = new ProjetoRepository(databaseUrl);
    }

    public void adicionarProjeto(Projeto projeto) throws SQLException {
        projetoRepository.createProjeto(projeto);
    }

    public Projeto obterProjeto(int id) throws SQLException {
        return projetoRepository.getProjeto(id);
    }

    public void atualizarProjeto(Projeto projeto) throws SQLException {
        projetoRepository.updateProjeto(projeto);
    }

    public void removerProjeto(Projeto projeto) throws SQLException {
        projetoRepository.deleteProjeto(projeto);
    }

    public List<Projeto> listarProjetos() throws SQLException {
        return projetoRepository.getAllProjetos();
    }

    public void fecharConexao() throws Exception, SQLException {
        projetoRepository.close();
    }
}

