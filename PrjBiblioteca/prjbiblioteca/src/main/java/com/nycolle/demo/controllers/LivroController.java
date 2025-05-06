package com.nycolle.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nycolle.demo.entities.Livro;
import com.nycolle.demo.services.LivroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscaPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroService.buscaPorId(id);
        return livro.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Livro>> buscarTodos() {
        List<Livro> livros = livroService.buscarTodos();
        return ResponseEntity.ok(livros);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.salvarLivro(livro);
        return ResponseEntity.ok(livroSalvo);
    }
}
