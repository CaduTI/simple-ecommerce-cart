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
import org.json.*;


import java.util.logging.Logger;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{

	@Autowired
	CarrinhoRepository repository;
	
	@Autowired
	UsuarioServiceImpl user;
	
	@Autowired	
	ProdutoServiceImpl produtoservices;
	
	@Autowired
	CarrinhoMapper mapper;
	
	private Logger logger = Logger.getLogger(CarrinhoService.class.getName());
	
	//pesquisa um carrinho de compras
	public CarrinhoDTO getCarrinho(UUID id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		var dto = mapper.toDTO(search);
		return dto;
	}
	
	// Atualiza os itens do carrinho
	public CarrinhoDTO updateCarrinho(CarrinhoDTO carrinho) {
		Carrinho entidade = repository.findById(carrinho.idCarrinho())
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		
		//entidade.setIdProduto(carrinho.idProduto());
		//entidade.setIdUsuario(carrinho.idUsuario());
		entidade.setPrecoTotal(carrinho.precoTotal());
		var dto = mapper.toDTO(entidade);
		return dto;
	}
	
	//cria um carrinho de compras de acordo com as informações do usuário e produto
	public CarrinhoDTO createCarrinho(CarrinhoDTO carrinho) {
		System.out.println(carrinho);
		Carrinho entidade = mapper.toEntity(carrinho);

		
		
		JSONObject json_parser = new JSONObject();
		json_parser= carrinho.listaProdutos();
				
				json_parser.toString();
		
		
		
		//entidade.setidProduto(getProd.id());
		entidade.setIdUsuario(carrinho.idUsuario());
		//entidade.setProdutos(json_parser);
		
		logger.info(carrinho.listaProdutos());
				
		CarrinhoDTO dto = mapper.toDTO(repository.save(entidade));

		logger.info("Criando carrinho com o Id: " +carrinho.idCarrinho());
		
		return dto;
	}

	//deleta o carrinho desejado
	public void deleteCarrinho(UUID id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		
		repository.delete(search);
		
	}
	
	
	//calcula o preço total de acordo com a soma dos valores dos produtos
	public Integer calculoPrecototal(CarrinhoDTO carrinho){
		
		return null;
	}
}
