package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Tarefa> getAllTarefas() {
        return tarefas;
    }

    public Tarefa getTarefaById(Long id) {
        Optional<Tarefa> tarefaOptional = tarefas.stream().filter(t -> t.getId().equals(id)).findFirst();
        return tarefaOptional.orElse(null);
    }

    public Tarefa addTarefa(Tarefa tarefa) {
        tarefa.setId(nextId++);
        tarefas.add(tarefa);
        return tarefa;
    }

    public void deleteTarefa(Long id) {
        tarefas.removeIf(t -> t.getId().equals(id));
    }
}
