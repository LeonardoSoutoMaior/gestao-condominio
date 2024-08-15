package com.example.gestao.service;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.reuniao.Reuniao;
import com.example.gestao.domain.tarefa.Tarefa;
import com.example.gestao.repositories.ReuniaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReuniaoService {

    @Autowired
    private ReuniaoRepository reuniaoRepository;

    @Autowired
    private CondominioService condominioService;

    public Reuniao criarReuniao(Reuniao reuniao){
        Condominio condominio = condominioService.buscarCondominioPorId(reuniao.getCondominio().getId());
        reuniao.setCondominio(condominio);
        return reuniaoRepository.save(reuniao);
    }

    public Reuniao buscarReuniaoPorId(UUID id){
        return reuniaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reunião não encontrada"));
    }

    public List<Reuniao> listarTarefas(){
        return reuniaoRepository.findAll();
    }

    public Reuniao atualizarReuniao(UUID id, Reuniao reuniao){
        Reuniao reuniaoExistente = buscarReuniaoPorId(id);

        reuniaoExistente.setDataReuniao(reuniao.getDataReuniao());
        reuniaoExistente.setHoraReuniao(reuniao.getHoraReuniao());
        reuniaoExistente.setLocalReuniao(reuniao.getLocalReuniao());
        reuniaoExistente.setPauta(reuniaoExistente.getPauta());

        return reuniaoRepository.save(reuniaoExistente);
    }

    public void deletarReuniao(UUID id){
        Reuniao reuniao = buscarReuniaoPorId(id);
        reuniaoRepository.delete(reuniao);
    }
}
