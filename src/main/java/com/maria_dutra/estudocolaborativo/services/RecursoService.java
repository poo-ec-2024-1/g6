package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.Recurso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    private List<Recurso> recursos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Recurso> getAllRecursos() {
        return recursos;
    }

    public Recurso getRecursoById(Long id) {
        Optional<Recurso> recursoOptional = recursos.stream().filter(r -> r.getId().equals(id)).findFirst();
        return recursoOptional.orElse(null);
    }

    public Recurso addRecurso(Recurso recurso) {
        recurso.setId(nextId++);
        recursos.add(recurso);
        return recurso;
    }

    public void deleteRecurso(Long id) {
        recursos.removeIf(r -> r.getId().equals(id));
    }
}
