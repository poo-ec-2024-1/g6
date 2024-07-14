
package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.Tarefa;
import com.maria_dutra.estudocolaborativo.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefaService.getAllTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa getTarefaById(@PathVariable Long id) {
        return tarefaService.getTarefaById(id);
    }

    @PostMapping
    public Tarefa addTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.addTarefa(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable Long id) {
        tarefaService.deleteTarefa(id);
    }
}
