package com.example.gestao.controller;

import com.example.gestao.domain.unidade.Unidade;
import com.example.gestao.repositories.UnidadeRepository;
import com.example.gestao.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @PostMapping
    public ResponseEntity<Unidade> criarUnidade(@RequestBody Unidade unidade){
        Unidade novaUnidade = unidadeService.criarUnidade(unidade);
        return ResponseEntity.ok(novaUnidade);
    }

    @GetMapping("/todasUnidades")
    public ResponseEntity<List<Unidade>> retornaUnidades(){
        List<Unidade> unidades = unidadeRepository.findAll();
        return ResponseEntity.ok(unidades);
    }
}
