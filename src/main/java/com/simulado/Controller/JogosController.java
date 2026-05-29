package com.simulado.Controller;

import com.simulado.Service.JogosService;
import com.simulado.dtos.JogosRequestDTO;
import com.simulado.dtos.JogosResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/jogos"})
@CrossOrigin

public class JogosController {
    @Autowired
    private JogosService jogosService;

    @PostMapping

    public JogosResponseDTO save(@RequestBody @Valid JogosRequestDTO jogosRequestDTO) {
        return jogosService.save(jogosRequestDTO);
    }
}



