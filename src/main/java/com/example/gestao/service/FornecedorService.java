package com.example.gestao.service;

import com.example.gestao.domain.fornecedor.Fornecedor;
import com.example.gestao.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor criarFornecedor(Fornecedor fornecedor){

        if (fornecedor.getNome() == null){
            throw new IllegalArgumentException("o nome não pode ser vazio");
        }

        if (fornecedorRepository.findByNome(fornecedor.getNome()).isPresent()){
            throw new IllegalArgumentException("Esse fornecedor já existe");
        }
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor buscarFornecedorPorId(UUID id){
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fornecedor não encontrado"));
    }

    public List<Fornecedor> listarFornecedor(){
        return fornecedorRepository.findAll();
    }

    public Fornecedor atualizarFornecedor(UUID id, Fornecedor fornecedor){
        Fornecedor fornecedorExistente = buscarFornecedorPorId(id);

        fornecedorExistente.setNome(fornecedor.getNome());
        fornecedorExistente.setServicoPrestado(fornecedor.getServicoPrestado());
        fornecedorExistente.setContato(fornecedor.getContato());
        fornecedorExistente.setAvaliacao(fornecedor.getAvaliacao());

        return fornecedorRepository.save(fornecedorExistente);
    }

    public void deletarFornecedor(UUID id){
        try{
            fornecedorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new IllegalArgumentException("Fornecedor não encontrado");
        }
    }
}
