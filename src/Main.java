import model.Aluno;
import repository.AlunoRepository;
import controller.AlunoController;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String databaseUrl = "jdbc:sqlite:mydatabase.db"; // Altere para o URL do seu banco de dados

        try {
            // Instanciar o controlador
            AlunoController alunoController = new AlunoController(databaseUrl);

            // Criar um novo aluno
            Aluno novoAluno = new Aluno(" Maria Dutra ", "maria.dutra@example.com", "senha123", "Engenharia", 123456, "Brasil");
            alunoController.adicionarAluno(novoAluno);

            // Listar todos os alunos
            List<Aluno> alunos = alunoController.listarAlunos();
            for (Aluno aluno : alunos) {
                System.out.println("Aluno: " + aluno.getNome() + ", Curso: " + aluno.getCurso());
            }

            // Atualizar um aluno
            novoAluno.setCurso("Matemática");
            alunoController.atualizarAluno(novoAluno);

            // Obter aluno atualizado
            Aluno alunoAtualizado = alunoController.obterAluno((int) novoAluno.getId());
            System.out.println("Aluno Atualizado: " + alunoAtualizado.getNome() + ", Curso: " + alunoAtualizado.getCurso());

            // Remover um aluno
            alunoController.removerAluno(novoAluno);

            // Fechar conexão
            alunoController.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

