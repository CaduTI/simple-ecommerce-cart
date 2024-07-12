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
import java.util.logging.Logger;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{

	@Autowired
	CarrinhoRepository repository;
	
	@Autowired
	UsuarioServiceImpl user;
	
	@Autowired	
	ProdutoServiceImpl produto;
	
	@Autowired
	CarrinhoMapper mapper;
	
	private Logger logger = Logger.getLogger(CarrinhoService.class.getName());
	
	//pesquisa um carrinho de compras
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
		var getUser = user.getUsuario(carrinho.idUsuario());
		var getProd = produto.getProdutoDTO(carrinho.idProduto());
		
		
		logger.info("Id do produto" + getProd);
		logger.info("Id do usuario" + getUser);
		
		
		entidade.setidProduto(getProd.id());
		System.out.println(getProd.id());
		entidade.setIdUsuario(getUser.user_Id());
		entidade.setPrecoTotal(getProd.preco());
	
		//System.out.println(entidade.getPrecoTotal());
		
		CarrinhoDTO dto = mapper.toDTO(repository.save(entidade));
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

	public CarrinhoDTO getCarrinho(UUID id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		var dto = mapper.toDTO(search);
		return dto;
	}

	
}
