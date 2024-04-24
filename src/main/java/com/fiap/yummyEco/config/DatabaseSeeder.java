package com.fiap.yummyEco.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fiap.yummyEco.model.Prato;
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
                // Prato.builder().id(1L).nome("Carbonara").valor(),
                // Prato.builder().id(1L).nome("Carbonara").valor()


            ));
            usuarioRepository.saveAll(
                List.of(
                    
                )    
            
            );
        
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    };


}
