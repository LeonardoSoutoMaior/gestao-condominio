package com.example.gestao.controller;

import com.example.gestao.domain.ocorrencia.Ocorrencia;
import com.example.gestao.domain.ocorrencia.OcorrenciaDTO;
import com.example.gestao.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarOcorrencia(@PathVariable UUID id){
        Ocorrencia ocorrencia = ocorrenciaService.buscarOcorrenciaPorId(id);
        return ResponseEntity.ok(ocorrencia);
    }

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listarOcorrencias(){
        List<Ocorrencia> ocorrencias = ocorrenciaService.listarOcorrencias();
        return ResponseEntity.ok(ocorrencias);
    }

}
