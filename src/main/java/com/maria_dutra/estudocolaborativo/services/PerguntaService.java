package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.Pergunta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerguntaService {

    private List<Pergunta> perguntas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Pergunta> getAllPerguntas() {
        return perguntas;
    }

    public Pergunta getPerguntaById(Long id) {
        Optional<Pergunta> perguntaOptional = perguntas.stream().filter(p -> p.getId().equals(id)).findFirst();
        return perguntaOptional.orElse(null);
    }

    public Pergunta addPergunta(Pergunta pergunta) {
        pergunta.setId(nextId++);
        perguntas.add(pergunta);
        return pergunta;
    }

    public void deletePergunta(Long id) {
        perguntas.removeIf(p -> p.getId().equals(id));
    }
}
