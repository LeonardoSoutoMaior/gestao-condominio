package com.example.gestao.repositories;

import com.example.gestao.domain.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
    Optional<Fornecedor> findByNome(String nome);
}
