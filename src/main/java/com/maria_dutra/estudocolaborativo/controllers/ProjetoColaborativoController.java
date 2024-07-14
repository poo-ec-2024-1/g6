
package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.ProjetoColaborativo;
import com.maria_dutra.estudocolaborativo.services.ProjetoColaborativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos-colaborativos")
public class ProjetoColaborativoController {

    @Autowired
    private ProjetoColaborativoService projetoColaborativoService;

    @GetMapping
    public List<ProjetoColaborativo> getAllProjetosColaborativos() {
        return projetoColaborativoService.getAllProjetosColaborativos();
    }

    @GetMapping("/{id}")
    public ProjetoColaborativo getProjetoColaborativoById(@PathVariable Long id) {
        return projetoColaborativoService.getProjetoColaborativoById(id);
    }

    @PostMapping
    public ProjetoColaborativo addProjetoColaborativo(@RequestBody ProjetoColaborativo projetoColaborativo) {
        return projetoColaborativoService.addProjetoColaborativo(projetoColaborativo);
    }

    @DeleteMapping("/{id}")
    public void deleteProjetoColaborativo(@PathVariable Long id) {
        projetoColaborativoService.deleteProjetoColaborativo(id);
    }

    // Endpoints de Colaboração
    @PostMapping("/{id}/comentar")
    public void comentar(@PathVariable Long id, @RequestBody String comentario) {
        projetoColaborativoService.comentar(id, comentario);
    }

    @PostMapping("/{id}/adicionarArquivo")
    public void adicionarArquivo(@PathVariable Long id, @RequestBody String arquivo) {
        projetoColaborativoService.adicionarArquivo(id, arquivo);
    }
}
