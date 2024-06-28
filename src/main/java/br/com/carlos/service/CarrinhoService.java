package br.com.carlos.service;

import br.com.carlos.dto.CarrinhoDTO;


public interface CarrinhoService {
	public CarrinhoDTO getCarrinho(String id);
	CarrinhoDTO createCarrinho(CarrinhoDTO carrinho);
	void deleteCarrinho(String id);
}
