package com.example.gestao.domain.ocorrencia;


import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.unidade.Unidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ocorrencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ocorrencia")
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_termino")
    private LocalDate dataTermino;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_unidade", nullable = false)
    private Unidade unidade;

}
