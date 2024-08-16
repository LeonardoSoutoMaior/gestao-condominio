package com.example.gestao.repositories;

import com.example.gestao.domain.equipamento.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipamentoRepository extends JpaRepository<Equipamento, UUID> {
}
