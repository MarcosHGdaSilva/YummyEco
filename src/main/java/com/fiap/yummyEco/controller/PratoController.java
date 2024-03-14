package com.fiap.yummyEco.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

@RestController
@RequestMapping("prato")
public class PratoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PratoRepository pratoRepository;

    @GetMapping
    public List<Prato> index() {
        return pratoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Prato create(@RequestBody Prato prato) {
        log.info("cadastrando prato: {}", prato);
        pratoRepository.save(prato);
        return prato;
    }

    @GetMapping("{id}")
    public ResponseEntity<Prato> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return pratoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("apagando prato {}", id);

        verificarSeExistePrato(id);

        pratoRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Prato prato){
        log.info("atualizando prato id {} para {}", id, prato);
        
        verificarSeExistePrato(id);

        prato.setId(id);
        pratoRepository.save(prato);
        return ResponseEntity.ok(prato);
    }

    private void verificarSeExistePrato(Long id) {
        pratoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prato não encontrado")
            );
    }

}
