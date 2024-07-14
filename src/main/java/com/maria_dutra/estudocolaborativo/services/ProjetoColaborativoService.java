package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.ProjetoColaborativo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoColaborativoService {

    private List<ProjetoColaborativo> projetosColaborativos = new ArrayList<>();
    private Long nextId = 1L;

    public List<ProjetoColaborativo> getAllProjetosColaborativos() {
        return projetosColaborativos;
    }

    public ProjetoColaborativo getProjetoColaborativoById(Long id) {
        Optional<ProjetoColaborativo> projetoColaborativoOptional = projetosColaborativos.stream().filter(p -> p.getId().equals(id)).findFirst();
        return projetoColaborativoOptional.orElse(null);
    }

    public ProjetoColaborativo addProjetoColaborativo(ProjetoColaborativo projetoColaborativo) {
        projetoColaborativo.setId(nextId++);
        projetosColaborativos.add(projetoColaborativo);
        return projetoColaborativo;
    }

    public void deleteProjetoColaborativo(Long id) {
        projetosColaborativos.removeIf(p -> p.getId().equals(id));
    }

    // Métodos de Colaboração
    public void comentar(Long id, String comentario) {
        ProjetoColaborativo projetoColaborativo = getProjetoColaborativoById(id);
        if (projetoColaborativo != null) {
            projetoColaborativo.comentar(comentario);
        }
    }

    public void adicionarArquivo(Long id, String arquivo) {
        ProjetoColaborativo projetoColaborativo = getProjetoColaborativoById(id);
        if (projetoColaborativo != null) {
            projetoColaborativo.adicionarArquivo(arquivo);
        }
    }
}
