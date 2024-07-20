package br.com.carlos.service;

import java.util.UUID;

import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.dto.CarrinhoDTORequest;


public interface CarrinhoService {
	public CarrinhoDTO getCarrinho(UUID id);
	public CarrinhoDTO updateCarrinho(CarrinhoDTO carrinho);
	CarrinhoDTO createCarrinho(CarrinhoDTORequest carrinho);
	void deleteCarrinho(UUID id);
	public Integer calculoPrecototal(CarrinhoDTORequest carrinho);
	
}
