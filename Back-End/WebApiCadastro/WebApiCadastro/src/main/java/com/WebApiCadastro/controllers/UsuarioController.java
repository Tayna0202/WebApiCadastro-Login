package com.WebApiCadastro.controllers;

import com.WebApiCadastro.entities.Usuario;
import com.WebApiCadastro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios () {
        List<Usuario> lista = (List<Usuario>) usuarioRepository.findAll();
        return ResponseEntity.status(200).body(lista);
    }
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return ResponseEntity.status(201).body(usuarioNovo);
    }
    @PutMapping
    public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return ResponseEntity.status(201).body(usuarioNovo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }
}
