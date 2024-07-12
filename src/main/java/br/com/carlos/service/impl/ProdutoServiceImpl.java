package br.com.carlos.service.impl;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.dto.ProdutoDTO;
import br.com.carlos.exceptions.ResourceNotFoundExcetion;
import br.com.carlos.mapper.ProdutoMapper;
import br.com.carlos.model.Produto;
import br.com.carlos.repository.ProdutoRepository;
import br.com.carlos.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	@Autowired
	ProdutoRepository repository;
	
	@Autowired
	ProdutoMapper mapper;
	
	private Logger logger = Logger.getLogger(ProdutoService.class.getName());
	
	public ProdutoDTO getProdutoDTO(UUID id) {
		System.out.println(id);
		Produto entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("No records for this id."));
		
		logger.info("Produto:  "+ entidade.getID() + " encontrado com sucesso!");
		var dto = mapper.toDTO(entidade);
		return dto;
	}

	
	public ProdutoDTO createProdutoDTO(ProdutoDTO produto) {
		var entidade = mapper.toEntity(produto);
		System.out.println(produto);
		System.out.println(entidade);
		var dto = mapper.toDTO(repository.save(entidade));
		
		return dto;
	}

	
	public ProdutoDTO updateProdutoDTO(ProdutoDTO produto) {
		Produto entidade = repository.findById(produto.id())
				.orElseThrow(() -> new ResourceNotFoundExcetion("No records for this id."));
		entidade.setNome(produto.nome());
		entidade.setPreco(produto.preco());
		entidade.setTipo(produto.tipo());
		
		var dto = mapper.toDTO(repository.save(entidade));
		
		return dto;
		
	}

	
	public void deleteProdutoDTO(UUID id) {
		var entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("No records for this id."));
		repository.delete(entidade);
	}


}
