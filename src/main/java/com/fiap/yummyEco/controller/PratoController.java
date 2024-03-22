package com.fiap.yummyEco.controller;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.fiap.yummyEco.model.Prato;
import com.fiap.yummyEco.repository.PratoRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("prato")
@Slf4j
public class PratoController {

    @Autowired
    PratoRepository pratoRepository;

    @GetMapping
    public List<Prato> index() {
        return pratoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Prato create(@RequestBody Prato prato) {
        log.info("cadastrando prato: {}", prato);
        return pratoRepository.save(prato);
    }

    @GetMapping("{id}")
    public ResponseEntity<Prato> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return pratoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando prato {}", id);

        verificarSeExistePrato(id);        
        pratoRepository.deleteById(id);

    }

    @PutMapping("{id}")
    public Prato update(@PathVariable Long id, @RequestBody Prato prato){
        log.info("atualizando prato id {} para {}", id, prato);
        
        verificarSeExistePrato(id);

        prato.setId(id);
        return pratoRepository.save(prato);
    }

    private void verificarSeExistePrato(Long id) {
        pratoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prato não encontrado")
            );
    }

}
