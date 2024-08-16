package com.example.gestao.service;

import com.example.gestao.domain.manutencao.Manutencao;
import com.example.gestao.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public Manutencao criarManutencao(Manutencao manutencao){
        return manutencaoRepository.save(manutencao);
    }

    public Manutencao buscarManutencaoPorId(UUID id){
        return manutencaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manutenção não encontrada"));
    }

    public List<Manutencao> listarManutencoes(){
        return manutencaoRepository.findAll();
    }

    public Manutencao atualizarManutencao(UUID id, Manutencao manutencao){
        Manutencao manutencaoExistente = buscarManutencaoPorId(id);

        manutencaoExistente.setDescricao(manutencao.getDescricao());
        manutencaoExistente.setDataAgendamento(manutencao.getDataAgendamento());
        manutencaoExistente.setDataExecucao(manutencao.getDataExecucao());
        manutencaoExistente.setCusto(manutencao.getCusto());

        return manutencaoRepository.save(manutencaoExistente);
    }

    public void deletarManutencao(UUID id){
        Manutencao manutencao = buscarManutencaoPorId(id);
        manutencaoRepository.delete(manutencao);
    }
}
