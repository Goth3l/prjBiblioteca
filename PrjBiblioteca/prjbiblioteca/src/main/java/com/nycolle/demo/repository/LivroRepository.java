package com.nycolle.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nycolle.demo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
