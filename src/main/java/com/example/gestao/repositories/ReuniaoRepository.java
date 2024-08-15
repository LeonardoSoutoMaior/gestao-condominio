package com.example.gestao.repositories;

import com.example.gestao.domain.reuniao.Reuniao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReuniaoRepository extends JpaRepository<Reuniao, UUID> {
}
