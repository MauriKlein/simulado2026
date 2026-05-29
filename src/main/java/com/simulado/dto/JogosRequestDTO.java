package com.simulado.dto;

import com.simulado.entity.Jogos;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JogosRequestDTO {


    @Size(min = 3, max = 100, message = "O titulo deve ter entre 3 ou 100 caracteres")
    private String titulo;
    @Positive
    private BigDecimal preco;
    @Min(value = 0, message = "O estoque deve um numero positivo")
    private Integer estoque;
    @Min(value = 0, message = "A classificação deve ser maior que 0")
    private Integer classificacaoIndicada;
    public static Jogos dtoToEntity(JogosRequestDTO jogosRequestDTO) {
        return Jogos.builder()
                .titulo(jogosRequestDTO.getTitulo())
                .preco(jogosRequestDTO.getPreco())
                .classificacaoIndicada(jogosRequestDTO.getClassificacaoIndicada())
                .estoque(jogosRequestDTO.getEstoque())
                .disponivel(jogosRequestDTO.getEstoque()>0)
                .build();
    }
}
