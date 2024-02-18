package com.WebApiCadastro.services;

import com.WebApiCadastro.dto.UsuarioDto;
import com.WebApiCadastro.entities.Usuario;
import com.WebApiCadastro.repositories.UsuarioRepository;
import com.WebApiCadastro.security.Token;
import com.WebApiCadastro.security.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    //Get
    public List<Usuario> listarUsuario(){
        logger.info("Usuario: " + getLogado() + " está listando os usuarios...");
        return usuarioRepository.findAll();
    }
    //Post
    public Usuario criarUsuario(Usuario usuario){
        String enconder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(enconder);
        this.passwordEncoder.encode(usuario.getConfirmarsenha());
        usuario.setConfirmarsenha(enconder);
        logger.info("Usuario: " + getLogado() + " criou o usuario: " + usuario.getNome());
        return usuarioRepository.save(usuario);
    }
    //Put
    public Usuario alterarUsuario(Usuario usuario){
        String enconder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(enconder);
        this.passwordEncoder.encode(usuario.getConfirmarsenha());
        usuario.setConfirmarsenha(enconder);
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        logger.info("Usuario: " + getLogado() + " está alterando o usuario: " + usuario.getNome());
        return usuarioNovo;
    }
    //Delete
    public Boolean deletarUsuario(Integer id){
        usuarioRepository.deleteById(id);
        logger.info("Usuario: " + getLogado() + " está deletando o usuario");
        return true;
    }

    public Token gerarToken(UsuarioDto usuario) {
        Usuario user = usuarioRepository.findBynome(usuario.getNome());
        if (user != null){
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if (valid){
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }
    private String getLogado(){
        Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
        if (!(userLogado instanceof AnonymousAuthenticationToken)){
            return userLogado.getName();
        }
        return "Null";
    }
}