package com.fiap.yummyEco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.yummyEco.model.Usuario;
import com.fiap.yummyEco.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @PostMapping
    public Usuario create(@RequestBody @Valid Usuario usuario){
        return repository.save(usuario);
    }
    
}
