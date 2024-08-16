package com.example.gestao.domain.manutencao;

import com.example.gestao.domain.equipamento.Equipamento;
import com.example.gestao.domain.fornecedor.Fornecedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "manutencao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_manutencao")
    private UUID id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_agendamento")
    @Temporal(TemporalType.DATE)
    private Date dataAgendamento;

    @Column(name = "data_execucao")
    @Temporal(TemporalType.DATE)
    private Date dataExecucao;

    @Column(name = "custo")
    private Double custo;

    @ManyToOne
    @JoinColumn(name = "id_equipamento", nullable = false)
    private Equipamento equipamento;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;
}
