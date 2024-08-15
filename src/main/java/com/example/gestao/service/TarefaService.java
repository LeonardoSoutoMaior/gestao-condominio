package com.example.gestao.service;

import com.example.gestao.domain.tarefa.Tarefa;
import com.example.gestao.repositories.CondominioRepository;
import com.example.gestao.repositories.TarefaRepository;
import com.example.gestao.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Tarefa criarTarefa(Tarefa tarefa){
        condominioRepository.findById(tarefa.getCondominio().getId())
                .orElseThrow(() -> new IllegalArgumentException("Condominio não encontrado"));

        usuarioRepository.findById(tarefa.getUsuario().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));

        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarTarefaPorId(UUID id){
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada!"));
    }

}
