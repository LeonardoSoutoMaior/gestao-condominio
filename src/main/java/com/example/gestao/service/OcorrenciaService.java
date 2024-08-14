package com.example.gestao.service;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.ocorrencia.Ocorrencia;
import com.example.gestao.domain.ocorrencia.OcorrenciaDTO;
import com.example.gestao.domain.unidade.Unidade;
import com.example.gestao.repositories.CondominioRepository;
import com.example.gestao.repositories.OcorrenciaRepository;
import com.example.gestao.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;


    public Ocorrencia criarOcorrencia(OcorrenciaDTO ocorrenciaDTO) {
        Optional<Unidade> unidadeOptional = unidadeRepository.findById(ocorrenciaDTO.getIdUnidade());

        if (unidadeOptional.isEmpty()){
            throw new IllegalArgumentException("Unidade não encontrada");
        }

        Unidade unidade = unidadeOptional.get();

        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setNome(ocorrenciaDTO.getNome());
        ocorrencia.setDescricao(ocorrenciaDTO.getDescricao());
        ocorrencia.setDataInicio(ocorrenciaDTO.getDataInicio());
        ocorrencia.setDataTermino(ocorrenciaDTO.getDataTermino());
        ocorrencia.setStatus(ocorrenciaDTO.getStatus());
        ocorrencia.setUnidade(unidade);

        return ocorrenciaRepository.save(ocorrencia);
    }



}
