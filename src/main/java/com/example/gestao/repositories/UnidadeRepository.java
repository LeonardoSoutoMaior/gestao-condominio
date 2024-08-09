package com.example.gestao.repositories;

import com.example.gestao.domain.unidade.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UnidadeRepository extends JpaRepository<Unidade, UUID> {
}
