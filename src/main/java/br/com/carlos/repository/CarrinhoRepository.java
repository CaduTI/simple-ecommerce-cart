package br.com.carlos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID>{

}
