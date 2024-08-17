package br.com.carlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{}
