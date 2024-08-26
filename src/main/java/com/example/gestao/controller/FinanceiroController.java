package com.example.gestao.controller;

import com.example.gestao.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
