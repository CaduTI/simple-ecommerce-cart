package br.com.carlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, String>{

}
