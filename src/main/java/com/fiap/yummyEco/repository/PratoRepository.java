package com.fiap.yummyEco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.yummyEco.model.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long> {
    
}
