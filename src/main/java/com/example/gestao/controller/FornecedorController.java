package com.example.gestao.controller;

import com.example.gestao.domain.fornecedor.Fornecedor;
import com.example.gestao.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor){
        Fornecedor novoFornecedor = fornecedorService.criarFornecedor(fornecedor);
        return ResponseEntity.ok(novoFornecedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorId(@PathVariable UUID id){
        Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(id);

        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores(){
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedor();
        return ResponseEntity.ok(fornecedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable UUID id, @RequestBody Fornecedor fornecedor){
        Fornecedor fornecedorAtualizado = fornecedorService.atualizarFornecedor(id, fornecedor);
        return ResponseEntity.ok(fornecedorAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable UUID id){
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
