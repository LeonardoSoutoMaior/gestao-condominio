package com.example.gestao.controller;

import com.example.gestao.domain.manutencao.Manutencao;
import com.example.gestao.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    @Autowired
    ManutencaoService manutencaoService;

    @PostMapping
    public ResponseEntity<Manutencao> criarManutencao(@RequestBody Manutencao manutencao){
        Manutencao novaManutencao = manutencaoService.criarManutencao(manutencao);
        return ResponseEntity.ok(manutencao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> buscarManutencaoPorId(@PathVariable UUID id){
        Manutencao manutencao = manutencaoService.buscarManutencaoPorId(id);

        return ResponseEntity.ok(manutencao);
    }

    @GetMapping
    public ResponseEntity<List<Manutencao>> listarManutencoes(){
        List<Manutencao> manutencoes = manutencaoService.listarManutencoes();
        return ResponseEntity.ok(manutencoes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> atualizarManutencao(@PathVariable UUID id, @RequestBody Manutencao manutencao){
        Manutencao manutencaoAtualizada = manutencaoService.atualizarManutencao(id, manutencao);
        return ResponseEntity.ok(manutencaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEquipamento(@PathVariable UUID id){
        manutencaoService.deletarManutencao(id);
        return ResponseEntity.noContent().build();
    }
}
