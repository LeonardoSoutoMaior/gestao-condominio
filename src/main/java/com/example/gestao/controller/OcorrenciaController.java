package com.example.gestao.controller;

import com.example.gestao.domain.ocorrencia.Ocorrencia;
import com.example.gestao.domain.ocorrencia.OcorrenciaDTO;
import com.example.gestao.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> criarOcorrencia(@RequestBody OcorrenciaDTO ocorrenciaDTO){
        Ocorrencia ocorrencia = ocorrenciaService.criarOcorrencia(ocorrenciaDTO);
        return ResponseEntity.ok(ocorrencia);
    }

}
