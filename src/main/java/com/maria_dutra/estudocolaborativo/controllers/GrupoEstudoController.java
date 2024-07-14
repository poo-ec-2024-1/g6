
package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.GrupoEstudo;
import com.maria_dutra.estudocolaborativo.services.GrupoEstudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoEstudoController {

    @Autowired
    private GrupoEstudoService grupoEstudoService;

    @GetMapping
    public List<GrupoEstudo> getAllGruposEstudo() {
        return grupoEstudoService.getAllGruposEstudo();
    }

    @GetMapping("/{id}")
    public GrupoEstudo getGrupoEstudoById(@PathVariable Long id) {
        return grupoEstudoService.getGrupoEstudoById(id);
    }

    @PostMapping
    public GrupoEstudo addGrupoEstudo(@RequestBody GrupoEstudo grupoEstudo) {
        return grupoEstudoService.addGrupoEstudo(grupoEstudo);
    }

    @DeleteMapping("/{id}")
    public void deleteGrupoEstudo(@PathVariable Long id) {
        grupoEstudoService.deleteGrupoEstudo(id);
    }
}
