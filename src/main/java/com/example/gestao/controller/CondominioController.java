package com.example.gestao.controller;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.condominio.CondominioRequestPayload;
import com.example.gestao.repositories.CondominioRepository;
import com.example.gestao.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
