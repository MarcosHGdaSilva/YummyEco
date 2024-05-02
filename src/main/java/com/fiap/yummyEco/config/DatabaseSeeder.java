package com.fiap.yummyEco.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fiap.yummyEco.model.Prato;
import com.fiap.yummyEco.model.Usuario;
import com.fiap.yummyEco.repository.PratoRepository;
import com.fiap.yummyEco.repository.UsuarioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PratoRepository pratoRepository;

    @Override
    public void run(String... args) throws Exception {
        
        pratoRepository.saveAll(
            List.of(
                    Prato.builder()
                    .nome("Carbonara")
                    .valor(new BigDecimal(123)).build(),
                Prato.builder()
                    .nome("Fettuccine alfredo")
                    .valor(new BigDecimal(123)).build(),
                Prato.builder()
                    .nome("Bolonhesa")
                    .valor(new BigDecimal(123)).build()
            ));
        usuarioRepository.saveAll(
            List.of(
                Usuario.builder()
                    .nome("João")
                    .email("Joao123@gmail.com")
                    .senha("joao123")
                    .prato(pratoRepository.findById(1L).get()).build(),
                Usuario.builder()
                    .nome("Paulo")
                    .email("Paulo123@gmail.com")
                    .senha("Paulo123")
                    .prato(pratoRepository.findById(2L).get()).build(),
                Usuario.builder()
                    .nome("Pedro")
                    .email("Pedro123@gmail.com")
                    .senha("Pedro123")
                    .prato(pratoRepository.findById(2L).get()).build(),
                Usuario.builder()
                    .nome("Carlos")
                    .email("Carlos123@gmail.com")
                    .senha("Carlos123")
                    .prato(pratoRepository.findById(3L).get()).build()  
            ));
    };


}
