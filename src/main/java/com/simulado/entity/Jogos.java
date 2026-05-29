package com.simulado.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private BigDecimal preco;
    private Integer estoque;
    private Integer classificacaoIndicada;
    private Boolean disponivel;
    private String codigoInterno;

    @PrePersist
    public void prePersist() {


        if (codigoInterno == null || codigoInterno.isBlank()) {
            codigoInterno = UUID.randomUUID().toString();
        }
    }
}


