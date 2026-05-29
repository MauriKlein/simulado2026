package com.simulado.service;

import com.simulado.dto.JogoRequestDTO;
import com.simulado.dto.JogoResponseDTO;
import com.simulado.entity.Jogos;
import com.simulado.handlers.MinhaException;
import com.simulado.repository.JogoRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;
    public JogoResponseDTO save(JogoRequestDTO dto) {

        return JogoResponseDTO.fromEntity(jogoRepository.save(JogoRequestDTO.dtoToEntity(dto)));

    }
    public JogoResponseDTO findById(Long id){
        Jogos jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Jogo não encontrado"+ id));
        return JogoResponseDTO.fromEntity(jogo);
    }
    public List<JogoResponseDTO> findAll(){
        return jogoRepository.findAll().stream()
                .map(JogoResponseDTO::fromEntity)
                .toList();
    }
    public JogoResponseDTO update(Long id, JogoRequestDTO dto) {
        Jogos jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new MinhaException("Jogo não encontrado para id : " + id));

        jogo.setTitulo(dto.getTitulo());
        jogo.setPreco(dto.getPreco());
        jogo.setEstoque(dto.getEstoque());
        jogo.setClassificacaoIndicativa(dto.getClassificacaoIndicativa());
        jogo.setDisponivel(dto.getEstoque() > 0);

        Jogos jogoAtualizado = jogoRepository.save(jogo);

        return JogoResponseDTO.fromEntity(jogoAtualizado);
    }
    public void delete(Long id){
        if(!jogoRepository.existsById(id)){
            throw new MinhaException("Jogo não encontrado para id : "+ id);
        }
        jogoRepository.deleteById(id);
    }
}
