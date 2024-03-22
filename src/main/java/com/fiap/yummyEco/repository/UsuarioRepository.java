package com.fiap.yummyEco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.yummyEco.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
