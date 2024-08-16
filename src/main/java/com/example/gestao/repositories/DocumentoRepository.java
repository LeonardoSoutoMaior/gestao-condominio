package com.example.gestao.repositories;

import com.example.gestao.domain.documento.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<Documento, UUID> {
}
