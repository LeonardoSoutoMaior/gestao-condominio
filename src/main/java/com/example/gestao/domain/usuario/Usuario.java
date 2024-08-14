package com.example.gestao.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private UUID id;

    @Column(name = "nome")
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 200)
    private String nome;

    @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Email deve ser válido")
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Senha não pode ser vazia")
    @Column(name = "senha")
    private String senha;
}
