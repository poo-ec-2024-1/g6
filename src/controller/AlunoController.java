package controller;

import model.Aluno;
import repository.AlunoRepository;
import java.sql.SQLException;
import java.util.List;

public class AlunoController {
    private AlunoRepository alunoRepository;

    public AlunoController(String databaseUrl) throws SQLException {
        alunoRepository = new AlunoRepository(databaseUrl);
    }

    public void adicionarAluno(Aluno aluno) throws SQLException {
        alunoRepository.createAluno(aluno);
    }

    public Aluno obterAluno(int id) throws SQLException {
        return alunoRepository.getAluno(id);
    }

    public void atualizarAluno(Aluno aluno) throws SQLException {
        alunoRepository.updateAluno(aluno);
    }

    public void removerAluno(Aluno aluno) throws SQLException {
        alunoRepository.deleteAluno(aluno);
    }

    public List<Aluno> listarAlunos() throws SQLException {
        return alunoRepository.getAllAlunos();
    }

    public void fecharConexao() throws Exception, SQLException {
        alunoRepository.close();
    }
}

