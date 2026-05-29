package com.simulado.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private BigDecimal preco;
    private Integer estoque;
    private Integer classificacaoIndicativa;
    private String codigoInterno;
    private Boolean disponivel;

    // lembra de fazer o properties, o nome é o mesmo da pasta

}
