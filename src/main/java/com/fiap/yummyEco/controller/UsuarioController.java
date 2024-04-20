package com.fiap.yummyEco.controller;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.yummyEco.model.Usuario;
import com.fiap.yummyEco.repository.UsuarioRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("usuario")
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario create(@RequestBody @Valid Usuario usuario){
        log.info("cadastrando usuario: {}", usuario);
        return usuarioRepository.save(usuario);
    }
    @GetMapping("{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id){
        log.info("buscando usuário por ID: {}", id);
        return usuarioRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete (@PathVariable Long id){
        log.info("deletando o usuário de id = {}", id);
        verificarexistencia(id);
        usuarioRepository.deleteById(id);
    }
    
    @PutMapping("{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        log.info("atualizando os dados do usuário com id={} para {}", id, usuario);
        verificarexistencia(id);
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    private void verificarexistencia(Long id) {
        usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuario não encontrado")
            );
    }
    
}
