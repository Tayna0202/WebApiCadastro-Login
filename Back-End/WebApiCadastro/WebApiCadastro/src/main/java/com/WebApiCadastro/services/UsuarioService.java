package com.WebApiCadastro.services;

import com.WebApiCadastro.entities.Usuario;
import com.WebApiCadastro.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    //Get
    public List<Usuario> listarUsuario(){
        List<Usuario> lista = usuarioRepository.findAll();
        return lista;
    }
    //Post
    public Usuario criarUsuario(Usuario usuario){
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return usuarioNovo;
    }
    //Put
    public Usuario alterarUsuario(Usuario usuario){
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return usuarioNovo;
    }
    //Delete
    public Boolean deletarUsuario(Integer id){
        usuarioRepository.deleteById(id);
        return true;
    }
}
