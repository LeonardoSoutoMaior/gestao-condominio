package com.example.gestao.controller;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.condominio.CondominioRequestPayload;
import com.example.gestao.repositories.CondominioRepository;
import com.example.gestao.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/condominio")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @Autowired
    private CondominioRepository condominioRepository;

    @PostMapping
    public ResponseEntity<Condominio> criarCondominio(@RequestBody CondominioRequestPayload payload){
        Condominio novoCondominio = this.condominioService.criarCondominio(payload);
        return ResponseEntity.ok(novoCondominio);
    }

    @GetMapping("/todosCondominios")
    public ResponseEntity<List<Condominio>> retornaCondominios(){
        List<Condominio> condominios = condominioRepository.findAll();
        return ResponseEntity.ok(condominios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Condominio> atualizaCondominio(@PathVariable UUID id, @RequestBody CondominioRequestPayload payload){
        Condominio condominioAtualizado = condominioService.atualizarcondominio(id,payload);
        return ResponseEntity.ok(condominioAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCondominio(@PathVariable UUID id){
        condominioService.deletarCondominio(id);
        return ResponseEntity.noContent().build();
    }
}
