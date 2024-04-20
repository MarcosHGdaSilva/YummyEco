package com.fiap.yummyEco.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Prato{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{prato.nome.notblank}")
    @Size(min = 3, message =  "{prato.nome.size}")
    private String nome;

    @Positive
    @NotNull(message = "{prato.valor.notnull}")
    private BigDecimal valor;
}
