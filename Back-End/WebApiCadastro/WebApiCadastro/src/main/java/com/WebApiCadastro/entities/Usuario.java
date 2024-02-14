package com.WebApiCadastro.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres!")
    @NotBlank(message = "O nome é obrigatório!")
    @Column(name = "nome", length = 100, nullable = true)
    private String nome;

    @Email(message = "Insira um e-mail válido!")
    @NotBlank(message = "O e-mail é obrigatório!")
    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @Size(min = 3, message = "Senha deve ter no mínimo 4 caracteres!")
    @NotBlank(message = "Senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;

    @Size(min = 3, message = "Confirmar Senha deve ter no mínimo 4 caracteres!")
    @NotBlank(message = "Confirmar Senha é obrigatória!")
    @Column(name = "confirmarsenha", columnDefinition = "TEXT", nullable = true)
    private String confirmarsenha;
}
