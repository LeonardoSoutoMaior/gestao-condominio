package com.example.gestao.controller;

import com.example.gestao.domain.tarefa.Tarefa;
import com.example.gestao.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa){
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefa(@PathVariable UUID id){
        Tarefa tarefa = tarefaService.buscarTarefaPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        List<Tarefa> tarefas = tarefaService.listarTarefa();
        return ResponseEntity.ok(tarefas);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable UUID id, @RequestBody Tarefa tarefa){
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable UUID id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
