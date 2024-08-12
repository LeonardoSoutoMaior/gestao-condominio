package com.example.gestao.domain.condominio;


import com.example.gestao.domain.unidade.Unidade;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_condominio")
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "quantidade_de_unidades")
    private int quantidadeDeUnidades;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Unidade> unidades;
}
