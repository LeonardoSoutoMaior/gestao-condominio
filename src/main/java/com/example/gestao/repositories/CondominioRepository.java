package com.example.gestao.repositories;

import com.example.gestao.domain.condominio.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CondominioRepository extends JpaRepository<Condominio, UUID> {

    Optional<Condominio> findByNome(String nome);
}
