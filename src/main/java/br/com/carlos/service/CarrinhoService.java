package br.com.carlos.service;

import java.util.UUID;

import br.com.carlos.dto.CarrinhoDTO;


public interface CarrinhoService {
	
	public CarrinhoDTO getCarrinho(UUID id);
	CarrinhoDTO createCarrinho(CarrinhoDTO carrinho);
	void deleteCarrinho(UUID id);
}
