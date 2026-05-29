package com.simulado.Service;

import com.simulado.Entity.Jogos;
import com.simulado.Repository.JogosRepository;
import com.simulado.dtos.JogosRequestDTO;
import com.simulado.dtos.JogosResponseDTO;
import com.simulado.handlers.MinhaException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosService {
    @Autowired
    private JogosRepository jogosRepository;

    public List <JogosResponseDTO> findAll() {
        return jogosRepository.findAll().stream()
                .map(JogosResponseDTO::fromEntity)
                .toList();
    }

    public JogosResponseDTO findById(Long id) {
        Jogos jogos = jogosRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Jogo não encontrado para o Id: " + id));
        return JogosResponseDTO.fromEntity(jogos);
    }

    public JogosResponseDTO save(JogosRequestDTO dto) {
        return JogosResponseDTO.fromEntity(jogosRepository.save(JogosRequestDTO.dtoToEntity(dto)));
    }
    public JogosResponseDTO update(Long id, JogosRequestDTO dto) {
        Jogos jogos = jogosRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Jogo nao encontrado para o id: " + id));

        jogos.setTitulo(dto.getTitulo());
        jogos.setPreco(dto.getPreco());
        jogos.setEstoque(dto.getEstoque());
        jogos.setClassificacaoIndicativa(dto.getClassificacaoIndicativa());
        return JogosResponseDTO.fromEntity(jogosRepository.save(jogos));
    }

    public void delete(Long id) {
        if (!jogosRepository.existsById(id)) {
            throw new MinhaException("Jogo nao encontrado para o id: " + id);
        }
        jogosRepository.deleteById(id);
    }

    }

