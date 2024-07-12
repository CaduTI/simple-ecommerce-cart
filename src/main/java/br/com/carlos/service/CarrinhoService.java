package br.com.carlos.service;

import java.util.UUID;

import br.com.carlos.dto.CarrinhoDTO;


public interface CarrinhoService {
	public CarrinhoDTO getCarrinho(UUID id);
	public CarrinhoDTO updateCarrinho(CarrinhoDTO carrinho);
	CarrinhoDTO createCarrinho(CarrinhoDTO carrinho);
	void deleteCarrinho(UUID id);
}
