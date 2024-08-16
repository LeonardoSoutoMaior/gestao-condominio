package com.example.gestao.controller;

import com.example.gestao.domain.condominio.Condominio;
import com.example.gestao.domain.documento.Documento;
import com.example.gestao.service.CondominioService;
import com.example.gestao.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private CondominioService condominioService;

    @PostMapping("/upload")
    public ResponseEntity<Documento> uploadDocumento(@RequestParam("file")MultipartFile file, @RequestParam("idCondominio") UUID idCondominio){
        try{
            Condominio condominio = condominioService.buscarCondominioPorId(idCondominio);
            Documento documento = documentoService.salvarDocumento(file, condominio);
            return ResponseEntity.ok(documento);

        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
