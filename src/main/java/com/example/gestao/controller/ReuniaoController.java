package com.example.gestao.controller;

import com.example.gestao.domain.reuniao.Reuniao;
import com.example.gestao.domain.tarefa.Tarefa;
import com.example.gestao.service.ReuniaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reuniao")
public class ReuniaoController {

    @Autowired
    private ReuniaoService reuniaoService;

    @PostMapping
    public ResponseEntity<Reuniao> criarReuniao(@RequestBody Reuniao reuniao){
        Reuniao novaReuniao = reuniaoService.criarReuniao(reuniao);
        return ResponseEntity.ok(novaReuniao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reuniao> buscarReuniaoPorId(@PathVariable UUID id){
        Reuniao reuniao = reuniaoService.buscarReuniaoPorId(id);
        return ResponseEntity.ok(reuniao);
    }

    @GetMapping
    public ResponseEntity<List<Reuniao>> listarReunioes(){
        List<Reuniao> reunioes = reuniaoService.listarTarefas();
        return ResponseEntity.ok(reunioes);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Reuniao> atualizarReuniao(@PathVariable UUID id, @RequestBody Reuniao reuniao){
        Reuniao reuniaoAtualizada = reuniaoService.atualizarReuniao(id, reuniao);
        return ResponseEntity.ok(reuniao);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarReuniao(@PathVariable UUID id){
        reuniaoService.deletarReuniao(id);
        return ResponseEntity.noContent().build();
    }
}
