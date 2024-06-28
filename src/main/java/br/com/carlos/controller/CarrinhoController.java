package br.com.carlos.controller;

import org.springframework.http.ResponseEntity;

import br.com.carlos.dto.CarrinhoDTO;

public interface CarrinhoController {
	public CarrinhoDTO getCarrinho(String idCarrinho);
	public CarrinhoDTO createPedido(CarrinhoDTO carrinho);
	ResponseEntity<?> deleteCarrinho(String idCarrinho);
	
	
}
