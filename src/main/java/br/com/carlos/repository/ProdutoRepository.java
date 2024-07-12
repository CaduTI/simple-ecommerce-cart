package br.com.carlos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{}
