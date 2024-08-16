package com.example.gestao.controller;

import com.example.gestao.domain.equipamento.Equipamento;
import com.example.gestao.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<Equipamento> criarEquipamento(@RequestBody Equipamento equipamento){
        Equipamento novoEquipamento = equipamentoService.criarEquipamento(equipamento);

        return ResponseEntity.ok(equipamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> buscarEquipamentoPorId(@PathVariable UUID id){
        Equipamento equipamento = equipamentoService.buscarEquipamentoPorId(id);
        return ResponseEntity.ok(equipamento);
    }

    @GetMapping
    public ResponseEntity<List<Equipamento>> listarEquipamentos(){
        List<Equipamento> equipamentos = equipamentoService.listarEquipamentos();
        return ResponseEntity.ok(equipamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizarEquipamento(@PathVariable UUID id, @RequestBody Equipamento equipamento){
        Equipamento equipamentoAtualizado = equipamentoService.atualizarEquipamento(id, equipamento);
        return ResponseEntity.ok(equipamentoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEquipamento(@PathVariable UUID id){
        equipamentoService.deletarEquipamento(id);
        return ResponseEntity.noContent().build();
    }
}
