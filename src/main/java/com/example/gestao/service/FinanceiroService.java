package com.example.gestao.service;

import com.example.gestao.repositories.DespesaRepository;
import com.example.gestao.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public BigDecimal calcularLucroOuPrejuizo(UUID condominioId, LocalDate startDate, LocalDate endDate) {
        BigDecimal totalReceitas = receitaRepository.sumValorByCondominioIdAndDateRange(condominioId, startDate, endDate);
        BigDecimal totalDespesas = despesaRepository.sumValorByCondominioIdAndDateRange(condominioId, startDate, endDate);

        if (totalDespesas == null) {
            totalDespesas = BigDecimal.ZERO;
        }
        if (totalReceitas == null) {
            totalReceitas = BigDecimal.ZERO;
        }

        return totalReceitas.subtract(totalDespesas);
    }


    public BigDecimal calcularLucroOuPrejuizoSemanal(UUID condominioId){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusWeeks(1);
        return calcularLucroOuPrejuizo(condominioId, startDate, endDate);
    }

    public BigDecimal calcularLucroOuPrejuizoMensal(UUID condominioId){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(1);
        return calcularLucroOuPrejuizo(condominioId, startDate, endDate);
    }

    public BigDecimal calcularLucroOuPrejuizoAnual(UUID condominioId){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusYears(1);
        return calcularLucroOuPrejuizo(condominioId, startDate, endDate);
    }
}
