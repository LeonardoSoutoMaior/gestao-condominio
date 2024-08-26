package com.example.gestao.repositories;

import com.example.gestao.domain.receita.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

public interface ReceitaRepository extends JpaRepository<Receita, UUID> {

    @Query("SELECT SUM(r.valor) FROM Receita r WHERE r.condominio.id = :condominioId")
    BigDecimal sumValorByCondominioId(@Param("condominioId") UUID condominioId);
}
