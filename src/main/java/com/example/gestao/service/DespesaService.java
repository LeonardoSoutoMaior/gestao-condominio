package com.example.gestao.service;

import com.example.gestao.domain.despesa.Despesa;
import com.example.gestao.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa criarDespesa(Despesa despesa){
        return despesaRepository.save(despesa);
    }

    public Despesa buscarDespesaPorId(UUID id){
        return despesaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Despesa não encontrada"));
    }

    public List<Despesa> listarDespesas(){
        return despesaRepository.findAll();
    }

    public Despesa atualizarDespesa(UUID id, Despesa despesa){
        Despesa despesaExistente = buscarDespesaPorId(id);

        despesaExistente.setDescricao(despesa.getDescricao());
        despesaExistente.setValor(despesa.getValor());
        despesaExistente.setDataEntrada(despesa.getDataEntrada());

        return despesaRepository.save(despesaExistente);
    }

    public void deletarDespesa(UUID id){
        Despesa despesa = buscarDespesaPorId(id);
        despesaRepository.delete(despesa);
    }
}
