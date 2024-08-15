package com.example.gestao.controller;

import com.example.gestao.domain.reuniao.Reuniao;
import com.example.gestao.service.ReuniaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reuniao")
public class ReuniaoController {

    @Autowired
    private ReuniaoService reuniaoService;

    @PostMapping
    public ResponseEntity<Reuniao> criarReuniao(@RequestBody Reuniao reuniao){
        Reuniao novaReuniao = reuniaoService.criarReuniao(reuniao);
        return ResponseEntity.ok(novaReuniao);
    }
}
