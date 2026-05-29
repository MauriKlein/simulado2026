package com.simulado.controller;

import com.simulado.dtos.JogoRequestDTO;
import com.simulado.dtos.JogoResponseDTO;
import com.simulado.entity.Jogo;
import com.simulado.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @PostMapping
    public JogoResponseDTO save(@RequestBody JogoRequestDTO jogoRequestDTO) {
        return jogoService.save(jogoRequestDTO);

    }

    @GetMapping("/{id}")
    public JogoResponseDTO findById(@PathVariable Long id) {
        return jogoService.findById(id);
    }

    @GetMapping()
    public List<JogoResponseDTO> findAll() {
        return jogoService.findAll();

    }

    @PutMapping("//{id}")
    public JogoResponseDTO update(@PathVariable Long id, @RequestBody JogoRequestDTO jogoRequestDTO) {
        return jogoService.updateEventos(id, jogoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Long id) {
        jogoService.deleteById(id);
    }
}