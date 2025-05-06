package com.nycolle.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nycolle.demo.entities.Livro;
import com.nycolle.demo.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Optional<Livro> buscaPorId(Long id) {
        return livroRepository.findById(id);
    }

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }
}