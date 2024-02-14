package com.WebApiCadastro.services;

import com.WebApiCadastro.entities.Usuario;
import com.WebApiCadastro.repositories.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    public UsuarioService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    //Get
    public List<Usuario> listarUsuario(){
        List<Usuario> lista = usuarioRepository.findAll();
        return lista;
    }
    //Post
    public Usuario criarUsuario(Usuario usuario){
        String enconder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(enconder);
        this.passwordEncoder.encode(usuario.getConfirmarsenha());
        usuario.setConfirmarsenha(enconder);
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return usuarioNovo;
    }
    //Put
    public Usuario alterarUsuario(Usuario usuario){
        String enconder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(enconder);
        this.passwordEncoder.encode(usuario.getConfirmarsenha());
        usuario.setConfirmarsenha(enconder);
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return usuarioNovo;
    }
    //Delete
    public Boolean deletarUsuario(Integer id){
        usuarioRepository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = usuarioRepository.getById(usuario.getId()).getSenha();
        Boolean validSenha = passwordEncoder.matches(usuario.getSenha(), senha);
        return validSenha;
    }

    public Boolean validarConfirmarSenha(Usuario usuario) {
        String confirmarSenha = usuarioRepository.getById(usuario.getId()).getConfirmarsenha();
        Boolean validConfirmarSenha = passwordEncoder.matches(usuario.getConfirmarsenha(), confirmarSenha);
        return validConfirmarSenha;
    }
}
