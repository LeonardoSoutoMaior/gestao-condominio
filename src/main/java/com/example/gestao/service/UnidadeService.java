package com.example.gestao.service;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.unidade.Unidade;
import com.example.gestao.repositories.CondominioRepository;
import com.example.gestao.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

    public Unidade atualizarUnidade(UUID id, Unidade unidade){
        Unidade unidadeExistente = unidadeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unidade não encontrada"));
        unidadeExistente.setNumero(unidade.getNumero());
        unidadeExistente.setAndar(unidade.getAndar());
        unidadeExistente.setCondominio(unidade.getCondominio());

        return unidadeRepository.save(unidadeExistente);
    }

    public void deletarUnidade(UUID id){
        try{
            unidadeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new IllegalArgumentException("Unidade não encontrada!");
        }
    }
}
