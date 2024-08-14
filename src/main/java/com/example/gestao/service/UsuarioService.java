package com.example.gestao.service;

import com.example.gestao.domain.usuario.Usuario;
import com.example.gestao.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario criarUsuario(Usuario usuario){
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()){
            throw new IllegalArgumentException("Este email já esta em uso");
        }
        return usuarioRepository.save(usuario);
    }
}
