package com.simulado.controller;

import com.simulado.Service.JogoService;
import com.simulado.dtos.JogoRequestDto;
import com.simulado.dtos.JogoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/jogo")

public class JogoController {


    @Autowired
    private JogoService jogoService;

    @PostMapping
    public JogoResponseDto criarJogo(@RequestBody JogoRequestDto jogoRequestDTO) {
        return jogoService.save(jogoRequestDTO);


    }
    @GetMapping("/{id}")
    public JogoResponseDto findById(@PathVariable Long id) {
        return jogoService.findById(id);
    }

@PutMapping("/{id}")
public JogoResponseDto update(@PathVariable Long id, @RequestBody JogoRequestDto eventosRequestDTO){
    return jogoService.updateEvento(id, eventosRequestDTO);
    }

    @DeleteMapping("/{id}")
    public String deletarJogo(@PathVariable Long id){
        return jogoService.deletarJogo(id);

    }
}
