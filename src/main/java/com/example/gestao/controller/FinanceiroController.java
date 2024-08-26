package com.example.gestao.controller;

import com.example.gestao.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping("/lucro-ou-prejuizo/{condominioId}")
    public ResponseEntity<BigDecimal> calcularLucroOuPrejuizo(@PathVariable UUID condominioId){
        BigDecimal resultado = financeiroService.calcularLucroOuPrejuizo(condominioId);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/lucro-prejuizo/semanal")
    public ResponseEntity<BigDecimal> calcularLucroOuPrejuizoSemanal(@RequestParam UUID condominioId){
        BigDecimal resultado = financeiroService.calcularLucroOuPrejuizoSemanal(condominioId);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/lucro-prejuizo/mensal")
    public ResponseEntity<BigDecimal> calcularLucroOuPrejuizoMensal(@RequestParam UUID condominioId){
        BigDecimal resultado = financeiroService.calcularLucroOuPrejuizoMensal(condominioId);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/lucro-prejuizo/anual")
    public ResponseEntity<BigDecimal> calcularLucroOuPrejuizoAnual(@RequestParam UUID condominioId){
        BigDecimal resultado = financeiroService.calcularLucroOuPrejuizoAnual(condominioId);
        return ResponseEntity.ok(resultado);
    }

}
