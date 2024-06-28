package br.com.carlos.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import br.com.carlos.dto.CarrinhoDTO;

public interface CarrinhoController {
	public CarrinhoDTO getCarrinho(UUID idCarrinho);
	public CarrinhoDTO createPedido(CarrinhoDTO carrinho);
	ResponseEntity<?> deleteCarrinho(UUID idCarrinho);
	
	
}
