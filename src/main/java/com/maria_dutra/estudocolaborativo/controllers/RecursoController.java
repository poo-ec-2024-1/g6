
package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.Recurso;
import com.maria_dutra.estudocolaborativo.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> getAllRecursos() {
        return recursoService.getAllRecursos();
    }

    @GetMapping("/{id}")
    public Recurso getRecursoById(@PathVariable Long id) {
        return recursoService.getRecursoById(id);
    }

    @PostMapping
    public Recurso addRecurso(@RequestBody Recurso recurso) {
        return recursoService.addRecurso(recurso);
    }

    @DeleteMapping("/{id}")
    public void deleteRecurso(@PathVariable Long id) {
        recursoService.deleteRecurso(id);
    }
}
