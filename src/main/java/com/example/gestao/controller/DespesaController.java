package com.example.gestao.controller;

import com.example.gestao.domain.despesa.Despesa;
import com.example.gestao.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<Despesa> criarDespesa(@RequestBody Despesa despesa){
        Despesa novaDespesa = despesaService.criarDespesa(despesa);
        return ResponseEntity.ok(novaDespesa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> buscarDespesaPorId(@PathVariable UUID id){
        Despesa despesa = despesaService.buscarDespesaPorId(id);
        return ResponseEntity.ok(despesa);
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listarDespesas(){
        List<Despesa> despesas = despesaService.listarDespesas();
        return ResponseEntity.ok(despesas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> atualizarDespesa(@PathVariable UUID id, @RequestBody Despesa despesa){
        Despesa despesaAtualizada = despesaService.atualizarDespesa(id, despesa);
        return ResponseEntity.ok(despesaAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarDespesa(@PathVariable UUID id){
        despesaService.deletarDespesa(id);
        return ResponseEntity.noContent().build();
    }

}
