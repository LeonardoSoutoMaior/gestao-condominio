package com.example.gestao.repositories;

import com.example.gestao.domain.manutencao.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManutencaoRepository extends JpaRepository<Manutencao, UUID> {
}
