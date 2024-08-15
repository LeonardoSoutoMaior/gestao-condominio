package com.example.gestao.domain.reuniao;

import com.example.gestao.domain.condominio.Condominio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "reuniao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reuniao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reuniao")
    private UUID id;

    @Column(name = "data_reuniao")
    private LocalDate dataReuniao;

    @Column(name = "hora_reuniao")
    private LocalTime horaReuniao;

    @Column(name = "local_reuniao")
    private String localReuniao;

    @Column(name = "pauta")
    private String pauta;

    @ManyToOne
    @JoinColumn(name = "id_condominio,", nullable = false)
    private Condominio condominio;
}
