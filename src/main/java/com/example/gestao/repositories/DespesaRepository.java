package com.example.gestao.repositories;

import com.example.gestao.domain.despesa.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DespesaRepository extends JpaRepository<Despesa, UUID> {
}
