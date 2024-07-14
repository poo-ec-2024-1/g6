package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.Projeto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private List<Projeto> projetos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Projeto> getAllProjetos() {
        return new ArrayList<>(projetos);
    }

    public Projeto getProjetoById(Long id) {
        return projetos.stream()
                .filter(projeto -> projeto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Projeto createProjeto(Projeto projeto) {
        projeto.setId(nextId++);
        projetos.add(projeto);
        return projeto;
    }

    public Projeto updateProjeto(Long id, Projeto projetoDetails) {
        Optional<Projeto> optionalProjeto = projetos.stream()
                .filter(projeto -> projeto.getId().equals(id))
                .findFirst();

        if (optionalProjeto.isPresent()) {
            Projeto projeto = optionalProjeto.get();
            projeto.setNome(projetoDetails.getNome());
            projeto.setDescricao(projetoDetails.getDescricao());
            projeto.setDataInicio(projetoDetails.getDataInicio());
            projeto.setDataFim(projetoDetails.getDataFim());
            projeto.setListaTarefas(projetoDetails.getListaTarefas());
            projeto.setListaAlunos(projetoDetails.getListaAlunos());
            return projeto;
        } else {
            return null;
        }
    }

    public boolean deleteProjeto(Long id) {
        return projetos.removeIf(projeto -> projeto.getId().equals(id));
    }
}
