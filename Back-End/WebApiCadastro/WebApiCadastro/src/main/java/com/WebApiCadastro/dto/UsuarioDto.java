package com.WebApiCadastro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    public UsuarioDto(String nome, String email, String senha, String confirmarsenha) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.confirmarsenha = confirmarsenha;
    }

    private String nome;
    private String email;
    private String senha;
    private String confirmarsenha;
}