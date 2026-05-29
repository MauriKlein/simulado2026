package com.simulado.service;

import com.simulado.dto.JogosRequestDTO;
import com.simulado.dto.JogosResponseDTO;
import com.simulado.entity.Jogos;
import com.simulado.handlers.MinhaException;
import com.simulado.repository.JogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JogosService {
    @Autowired
    private JogosRepository jogosRepository;

    public JogosResponseDTO save(JogosRequestDTO dto) {

        return JogosResponseDTO.fromEntity(jogosRepository.save(JogosRequestDTO.dtoToEntity(dto)));
    }

    public JogosResponseDTO findById(Long id) {
        Jogos jogo = jogosRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Jogo nao encontrado para o id: " + id));
        return JogosResponseDTO.fromEntity(jogo);
    }

    public List<JogosResponseDTO> findAll() {
        return jogosRepository.findAll().stream()
                .map(JogosResponseDTO::fromEntity)
                .toList();
    }

    public JogosResponseDTO update(Long id, JogosRequestDTO dto) {
        Jogos jogo = jogosRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Jogo nao encontrado para o id: " + id));

        jogo.setTitulo(dto.getTitulo());
        jogo.setPreco(dto.getPreco());
        jogo.setEstoque(dto.getEstoque());
        jogo.setClassificacaoIndicada(dto.getClassificacaoIndicada());
        return JogosResponseDTO.fromEntity(jogosRepository.save(jogo));
    }

    public void delete(Long id) {
        if (!jogosRepository.existsById(id)) {
            throw new MinhaException("Jogo nao encontrado para o id: " + id);
        }
        jogosRepository.deleteById(id);
    }
}
