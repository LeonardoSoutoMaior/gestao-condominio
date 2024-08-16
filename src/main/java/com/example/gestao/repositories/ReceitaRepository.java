package com.example.gestao.repositories;

import com.example.gestao.domain.receita.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReceitaRepository extends JpaRepository<Receita, UUID> {
}
