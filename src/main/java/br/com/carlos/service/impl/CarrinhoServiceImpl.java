package br.com.carlos.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.exceptions.ResourceNotFoundExcetion;
import br.com.carlos.mapper.CarrinhoMapper;
import br.com.carlos.model.Carrinho;
import br.com.carlos.repository.CarrinhoRepository;
import br.com.carlos.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{

	@Autowired
	CarrinhoRepository repository;
	
	@Autowired
	CarrinhoMapper mapper;
	
	//pesquisa um carrinho de compras
	public CarrinhoDTO getCarrinho(UUID id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		var dto = mapper.toDTO(search);
		return dto;
	}
	
	//cria um carrinho de compras de acordo com as informações do usuário e produto
	public CarrinhoDTO createCarrinho(CarrinhoDTO carrinho) {
		Carrinho entidade = mapper.toEntity(carrinho);
		CarrinhoDTO dto = mapper.toDTO(entidade);
		
		System.out.println(entidade.getIdCarrinho());
		
		System.out.println(dto.idCarrinho());
		System.out.println(dto.idProduto());
		System.out.println(dto.idUsuario());
		System.out.println(dto.precoTotal());
		return dto;
	}

	//deleta o carrinho desejado
	public void deleteCarrinho(UUID id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		
		repository.delete(search);
		
	}

	
}
