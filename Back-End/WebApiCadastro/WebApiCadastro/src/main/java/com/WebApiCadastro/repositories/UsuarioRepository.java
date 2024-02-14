package com.WebApiCadastro.repositories;

import com.WebApiCadastro.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
