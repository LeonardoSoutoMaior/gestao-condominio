package com.example.gestao.service;

import com.example.gestao.domain.receita.Receita;
import com.example.gestao.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita criarReceita(Receita receita){
        return receitaRepository.save(receita);
    }

    public Receita buscarReceitaPorId(UUID id){
        return receitaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Receita não encontrada"));
    }

    public List<Receita> listarReceitas(){
        return receitaRepository.findAll();
    }

    public Receita atualizarReceita(UUID id, Receita receita){
        Receita receitaExistente = buscarReceitaPorId(id);

        receitaExistente.setDescricao(receita.getDescricao());
        receitaExistente.setValor(receita.getValor());
        receitaExistente.setDataEntrada(receita.getDataEntrada());

        return receitaRepository.save(receitaExistente);
    }

    public void deletarReceita(UUID id){
        Receita receita = buscarReceitaPorId(id);
        receitaRepository.delete(receita);
    }
}
