package controller;

import model.ProjetoColaborativo;
import repository.ProjetoColaborativoRepository;
import java.sql.SQLException;
import java.util.List;

public class ProjetoColaborativoController {
    private ProjetoColaborativoRepository projetoColaborativoRepository;

    public ProjetoColaborativoController(String databaseUrl) throws SQLException {
        projetoColaborativoRepository = new ProjetoColaborativoRepository(databaseUrl);
    }

    public void adicionarProjetoColaborativo(ProjetoColaborativo projetoColaborativo) throws SQLException {
        projetoColaborativoRepository.createProjetoColaborativo(projetoColaborativo);
    }

    public ProjetoColaborativo obterProjetoColaborativo(int id) throws SQLException {
        return projetoColaborativoRepository.getProjetoColaborativo(id);
    }

    public void atualizarProjetoColaborativo(ProjetoColaborativo projetoColaborativo) throws SQLException {
        projetoColaborativoRepository.updateProjetoColaborativo(projetoColaborativo);
    }

    public void removerProjetoColaborativo(ProjetoColaborativo projetoColaborativo) throws SQLException {
        projetoColaborativoRepository.deleteProjetoColaborativo(projetoColaborativo);
    }

    public List<ProjetoColaborativo> listarProjetosColaborativos() throws SQLException {
        return projetoColaborativoRepository.getAllProjetosColaborativos();
    }

    public void fecharConexao() throws Exception, SQLException {
        projetoColaborativoRepository.close();
    }
}
