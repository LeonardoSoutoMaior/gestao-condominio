package com.example.gestao.domain.unidade;

import com.example.gestao.domain.condominio.Condominio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "unidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_unidade")
    private UUID id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "andar")
    private String andar;

    @ManyToOne
    @JoinColumn(name = "id_condominio", nullable = false)
    @JsonBackReference
    private Condominio condominio;

}
