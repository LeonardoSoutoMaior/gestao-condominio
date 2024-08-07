package com.example.gestao.service;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.condominio.CondominioRequestPayload;
import com.example.gestao.repositories.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    public Condominio criarCondominio(CondominioRequestPayload payload){

        if (payload.nome() == null){
            throw new IllegalArgumentException("O nome do condomínio não pode ser vazio");
        }

        if (condominioRepository.findByNome(payload.nome()).isPresent()){
            throw new IllegalArgumentException("Esse condomínio já existe");
        }

        Condominio novoCondominio = new Condominio();
        novoCondominio.setNome(payload.nome());
        novoCondominio.setEndereco(payload.endereco());
        novoCondominio.setQuantidadeDeUnidades(payload.quantidadeDeUnidades());

        return condominioRepository.save(novoCondominio);
    }


}
