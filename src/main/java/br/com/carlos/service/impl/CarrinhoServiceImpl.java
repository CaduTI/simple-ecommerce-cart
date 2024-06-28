package br.com.carlos.service.impl;

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
	@Override
	public CarrinhoDTO getCarrinho(String id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		var dto = mapper.toDTO(search);
		return dto;
	}

	@Override
	public CarrinhoDTO createCarrinho(CarrinhoDTO carrinho) {
		Carrinho entidade = mapper.toEntity(carrinho);
		CarrinhoDTO dto = mapper.toDTO(entidade);
		return dto;
	}

	

	@Override
	public void deleteCarrinho(String id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		
		repository.delete(search);
		
	}

	
}
