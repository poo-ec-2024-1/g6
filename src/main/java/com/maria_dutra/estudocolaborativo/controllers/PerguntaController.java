
package com.maria_dutra.estudocolaborativo.controllers;

import com.maria_dutra.estudocolaborativo.models.Pergunta;
import com.maria_dutra.estudocolaborativo.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @GetMapping
    public List<Pergunta> getAllPerguntas() {
        return perguntaService.getAllPerguntas();
    }

    @GetMapping("/{id}")
    public Pergunta getPerguntaById(@PathVariable Long id) {
        return perguntaService.getPerguntaById(id);
    }

    @PostMapping
    public Pergunta addPergunta(@RequestBody Pergunta pergunta) {
        return perguntaService.addPergunta(pergunta);
    }

    @DeleteMapping("/{id}")
    public void deletePergunta(@PathVariable Long id) {
        perguntaService.deletePergunta(id);
    }
}
