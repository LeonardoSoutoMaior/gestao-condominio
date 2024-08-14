package com.example.gestao.domain.ocorrencia;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class OcorrenciaDTO {
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String status;
    private UUID idUnidade;
}
