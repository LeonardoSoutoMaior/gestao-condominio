package com.example.gestao.service;

import com.example.gestao.repositories.DespesaRepository;
import com.example.gestao.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class FinanceiroService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    public BigDecimal calcularLucroOuPrejuizo(UUID condominioId){
        BigDecimal totalReceitas = receitaRepository.sumValorByCondominioId(condominioId);
        BigDecimal totalDespesas = despesaRepository.sumValorByCondominioId(condominioId);

        if (totalDespesas == null){
            totalDespesas = BigDecimal.ZERO;
        }
        if (totalReceitas == null){
            totalReceitas = BigDecimal.ZERO;
        }

        return totalReceitas.subtract(totalDespesas);
    }
}
