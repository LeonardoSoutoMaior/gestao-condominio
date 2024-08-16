package com.example.gestao.domain.fornecedor;

import com.example.gestao.domain.condominio.Condominio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "fornecedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fornecedor")
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "servico_prestado")
    private String servicoPrestado;

    @Column(name = "contato")
    private String contato;

    @Column(name = "avaliacao")
    private Integer avaliacao;

    @ManyToOne
    @JoinColumn(name = "id_condominio", nullable = false)
    private Condominio condominio;
}
