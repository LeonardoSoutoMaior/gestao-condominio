package com.example.gestao.controller;

import com.example.gestao.domain.receita.Receita;
import com.example.gestao.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Receita> criarReceita(@RequestBody Receita receita){
        Receita novaReceita = receitaService.criarReceita(receita);
        return ResponseEntity.ok(novaReceita);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscarReceitaPorId(@PathVariable UUID id){
        Receita receita = receitaService.buscarReceitaPorId(id);
        return ResponseEntity.ok(receita);
    }

    @GetMapping
    public ResponseEntity<List<Receita>> listarReceita(){
        List<Receita> receita = receitaService.listarReceitas();
        return ResponseEntity.ok(receita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizarReceita(@PathVariable UUID id, @RequestBody Receita receita){
        Receita receitaAtualizada = receitaService.atualizarReceita(id, receita);
        return ResponseEntity.ok(receitaAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarReceita(@PathVariable UUID id){
        receitaService.deletarReceita(id);
        return ResponseEntity.noContent().build();
    }
}
