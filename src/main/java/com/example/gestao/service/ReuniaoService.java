package com.example.gestao.service;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.reuniao.Reuniao;
import com.example.gestao.repositories.ReuniaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
