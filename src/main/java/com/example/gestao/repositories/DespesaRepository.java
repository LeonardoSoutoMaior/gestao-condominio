package com.example.gestao.repositories;

import com.example.gestao.domain.despesa.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface DespesaRepository extends JpaRepository<Despesa, UUID> {

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.condominio.id = :condominioId")
    BigDecimal sumValorByCondominioId(@Param("condominioId") UUID condominioId);

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.condominio.id = :condominioId AND d.dataEntrada BETWEEN :startDate AND :endDate")
    BigDecimal sumValorByCondominioIdAndDateRange(@Param("condominioId") UUID condominioId,
                                                  @Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate);
}
