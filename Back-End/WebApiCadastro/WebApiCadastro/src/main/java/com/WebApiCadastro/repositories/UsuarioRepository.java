package com.WebApiCadastro.repositories;

import com.WebApiCadastro.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}
