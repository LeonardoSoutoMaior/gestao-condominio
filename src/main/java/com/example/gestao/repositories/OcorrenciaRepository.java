package com.example.gestao.repositories;

import com.example.gestao.domain.ocorrencia.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, UUID> {
}
