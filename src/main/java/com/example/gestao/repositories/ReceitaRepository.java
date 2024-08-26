package com.example.gestao.repositories;

import com.example.gestao.domain.receita.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface ReceitaRepository extends JpaRepository<Receita, UUID> {

    @Query("SELECT SUM(r.valor) FROM Receita r WHERE r.condominio.id = :condominioId")
    BigDecimal sumValorByCondominioId(@Param("condominioId") UUID condominioId);

    @Query("SELECT SUM(r.valor) FROM Receita r WHERE r.condominio.id = :condominioId AND r.dataEntrada BETWEEN :startDate AND :endDate")
    BigDecimal sumValorByCondominioIdAndDateRange(@Param("condominioId") UUID condominioId,
                                                  @Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate);
}
