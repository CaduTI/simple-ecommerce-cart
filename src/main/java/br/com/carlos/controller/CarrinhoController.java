package br.com.carlos.controller;

import java.util.UUID;

import br.com.carlos.dto.CarrinhoDTORequest;
import org.springframework.http.ResponseEntity;

import br.com.carlos.dto.CarrinhoDTO;

public interface CarrinhoController {
	public CarrinhoDTO getCarrinho(UUID idCarrinho);
	public CarrinhoDTO createPedido(CarrinhoDTORequest carrinho);
	ResponseEntity<?> deleteCarrinho(UUID idCarrinho);
	
	
}
