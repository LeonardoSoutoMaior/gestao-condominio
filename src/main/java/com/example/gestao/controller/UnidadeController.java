package com.example.gestao.controller;

import com.example.gestao.domain.unidade.Unidade;
import com.example.gestao.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping
    public ResponseEntity<Unidade> criarUnidade(@RequestBody Unidade unidade){
        Unidade novaUnidade = unidadeService.criarUnidade(unidade);
        return ResponseEntity.ok(novaUnidade);
    }
}
