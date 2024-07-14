
package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.GrupoEstudo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoEstudoService {

    private List<GrupoEstudo> gruposEstudo = new ArrayList<>();
    private Long nextId = 1L;

    public List<GrupoEstudo> getAllGruposEstudo() {
        return gruposEstudo;
    }

    public GrupoEstudo getGrupoEstudoById(Long id) {
        Optional<GrupoEstudo> grupoEstudoOptional = gruposEstudo.stream().filter(g -> g.getId().equals(id)).findFirst();
        return grupoEstudoOptional.orElse(null);
    }

    public GrupoEstudo addGrupoEstudo(GrupoEstudo grupoEstudo) {
        grupoEstudo.setId(nextId++);
        gruposEstudo.add(grupoEstudo);
        return grupoEstudo;
    }

    public void deleteGrupoEstudo(Long id) {
        gruposEstudo.removeIf(g -> g.getId().equals(id));
    }
}
