
package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.Aluno;
import com.maria_dutra.estudocolaborativo.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunoService.getAlunoById(id);
    }

    @PostMapping
    public Aluno addAluno(@RequestBody Aluno aluno) {
        return alunoService.addAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }
}
