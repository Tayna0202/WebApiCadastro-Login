package com.WebApiCadastro.controllers;

import com.WebApiCadastro.entities.Usuario;
import com.WebApiCadastro.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios () {
        return ResponseEntity.status(200).body(usuarioService.listarUsuario());
    }
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }
    @PutMapping
    public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(200).body(usuarioService.alterarUsuario(usuario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(204).build();
    }
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }
    @PostMapping("/login")
    public ResponseEntity<Usuario> validarSenha(@RequestBody Usuario usuario){
        Boolean valid = usuarioService.validarSenha(usuario);
        Boolean validConfirmarSenha = usuarioService.validarConfirmarSenha(usuario);
        if (!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (!validConfirmarSenha){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    }
}
