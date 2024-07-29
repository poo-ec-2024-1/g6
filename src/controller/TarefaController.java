package controller;

import model.Tarefa;
import repository.TarefaRepository;
import java.sql.SQLException;
import java.util.List;

public class TarefaController {
    private TarefaRepository tarefaRepository;

    public TarefaController(String databaseUrl) throws SQLException {
        tarefaRepository = new TarefaRepository(databaseUrl);
    }

    public void adicionarTarefa(Tarefa tarefa) throws SQLException {
        tarefaRepository.createTarefa(tarefa);
    }

    public Tarefa obterTarefa(int id) throws SQLException {
        return tarefaRepository.getTarefa(id);
    }

    public void atualizarTarefa(Tarefa tarefa) throws SQLException {
        tarefaRepository.updateTarefa(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) throws SQLException {
        tarefaRepository.deleteTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() throws SQLException {
        return tarefaRepository.getAllTarefas();
    }

    public void fecharConexao() throws Exception, SQLException {
        tarefaRepository.close();
    }
}

