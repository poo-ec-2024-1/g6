
package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.Aluno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> alunoOptional = alunos.stream().filter(a -> a.getId().equals(id)).findFirst();
        return alunoOptional.orElse(null);
    }

    public Aluno addAluno(Aluno aluno) {
        aluno.setId(nextId++);
        alunos.add(aluno);
        return aluno;
    }

    public void deleteAluno(Long id) {
        alunos.removeIf(a -> a.getId().equals(id));
    }
}
