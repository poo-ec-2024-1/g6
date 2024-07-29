package controller;

import model.GrupoEstudo;
import repository.GrupoEstudoRepository;
import java.sql.SQLException;
import java.util.List;

public class GrupoEstudoController {
    private GrupoEstudoRepository grupoEstudoRepository;

    public GrupoEstudoController(String databaseUrl) throws SQLException {
        grupoEstudoRepository = new GrupoEstudoRepository(databaseUrl);
    }

    public void adicionarGrupoEstudo(GrupoEstudo grupoEstudo) throws SQLException {
        grupoEstudoRepository.createGrupoEstudo(grupoEstudo);
    }

    public GrupoEstudo obterGrupoEstudo(int id) throws SQLException {
        return grupoEstudoRepository.getGrupoEstudo(id);
    }

    public void atualizarGrupoEstudo(GrupoEstudo grupoEstudo) throws SQLException {
        grupoEstudoRepository.updateGrupoEstudo(grupoEstudo);
    }

    public void removerGrupoEstudo(GrupoEstudo grupoEstudo) throws SQLException {
        grupoEstudoRepository.deleteGrupoEstudo(grupoEstudo);
    }

    public List<GrupoEstudo> listarGruposEstudo() throws SQLException {
        return grupoEstudoRepository.getAllGruposEstudo();
    }

    public void fecharConexao() throws Exception, SQLException {
        grupoEstudoRepository.close();
    }
}

