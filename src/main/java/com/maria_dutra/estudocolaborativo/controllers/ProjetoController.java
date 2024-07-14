package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.Projeto;
import com.maria_dutra.estudocolaborativo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> getAllProjetos() {
        return projetoService.getAllProjetos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
        Projeto projeto = projetoService.getProjetoById(id);
        return projeto != null ? ResponseEntity.ok(projeto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Projeto createProjeto(@RequestBody Projeto projeto) {
        return projetoService.createProjeto(projeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projetoDetails) {
        Projeto projeto = projetoService.updateProjeto(id, projetoDetails);
        return projeto != null ? ResponseEntity.ok(projeto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjeto(@PathVariable Long id) {
        boolean isDeleted = projetoService.deleteProjeto(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
