package com.example.gestao.service;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.unidade.Unidade;
import com.example.gestao.repositories.CondominioRepository;
import com.example.gestao.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    public Unidade criarUnidade(Unidade unidade){
        Optional<Condominio> condominioExistente = condominioRepository.findById(unidade.getCondominio().getId());

        if (condominioExistente.isEmpty()){
            throw new IllegalArgumentException("Condominio não encontrado");
        }

        Optional<Unidade> unidadeExistente = unidadeRepository.findByNumeroAndAndarAndCondominioId(
                unidade.getNumero(), unidade.getAndar(), unidade.getCondominio().getId()
        );

        if (unidadeExistente.isPresent()){
            throw new IllegalArgumentException("Unidade já existente no condomínio");
        }
        return unidadeRepository.save(unidade);
    }
}
