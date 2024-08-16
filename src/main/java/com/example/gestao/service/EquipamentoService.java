package com.example.gestao.service;

import com.example.gestao.domain.equipamento.Equipamento;
import com.example.gestao.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Equipamento criarEquipamento(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento buscarEquipamentoPorId(UUID id){
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipamento não encontrado"));
    }

    public List<Equipamento> listarEquipamentos(){
        return equipamentoRepository.findAll();
    }

    public Equipamento atualizarEquipamento(UUID id, Equipamento equipamento){
        Equipamento equipamentoExistente = buscarEquipamentoPorId(id);

        equipamentoExistente.setNome(equipamento.getNome());
        equipamentoExistente.setDetalhesTecnicos(equipamento.getDetalhesTecnicos());

        return equipamentoRepository.save(equipamentoExistente);
    }

    public void deletarEquipamento(UUID id){
        Equipamento equipamento = buscarEquipamentoPorId(id);
        equipamentoRepository.delete(equipamento);
    }
}
