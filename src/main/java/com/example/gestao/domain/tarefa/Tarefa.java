package com.example.gestao.domain.tarefa;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tarefa")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;

    @Column(name = "prioridade")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_condominio", nullable = false)
    private Condominio condominio;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public enum Prioridade {
        ALTA, MEDIA, BAIXA
    }

    public enum Status {
        PENDENTE, EM_ANDAMENTO, CONCLUIDO
    }
}
