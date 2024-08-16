package com.example.gestao.domain.documento;

import com.example.gestao.domain.condominio.Condominio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "documento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "url")
    private String url;

    @Column(name = "data_upload")
    @Temporal(TemporalType.DATE)
    private Date dataUpload;

    @ManyToOne
    @JoinColumn(name = "id_condominio", nullable = false)
    private Condominio condominio;
}
