package com.fiap.yummyEco.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Prato{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    
    @NotBlank(message = "{prato.nome.notblank}")
    @Size(min = 3, message =  "{prato.nome.size}")
    private String nome;

    private String id;

    @Positive
    @NotBlank(message = "{prato.valor.notblank}")
    private BigDecimal valor;
}
