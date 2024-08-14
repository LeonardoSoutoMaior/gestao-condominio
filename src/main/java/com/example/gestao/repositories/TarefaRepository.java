package com.example.gestao.repositories;

import com.example.gestao.domain.tarefa.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {
}
