package com.simulado.dtos;

import ch.qos.logback.core.status.Status;
import com.simulado.entity.Jogo;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data

public class JogoRequestDto {
    @NotBlank( message = "O título deve ser preenchido")
    private String titulo;

    @DecimalMin(value = "0.0", message = "O valor da inscrição deve ser positivo")
    private BigDecimal preco;

    @Positive(message = "Esse campo deve ser preenchido")
    private Integer classificacaoIndicativa;

    @Min(value = 0, message =  " O estoque presisa ser positivo")
    private Integer estoque;





    public static Jogo dtoToEntity(JogoRequestDto dto) {
        return Jogo.builder()
                .titulo(dto.titulo)
                .preco(dto.preco)
                .classificacaoIndicativa(dto.classificacaoIndicativa)
                .estoque(dto.estoque)
                .codigoInterno(java.util.UUID.randomUUID().toString())
                .build();
    }
}