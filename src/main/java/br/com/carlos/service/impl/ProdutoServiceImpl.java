package br.com.carlos.service.impl;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.data.vo.ProdutoVO;
import br.com.carlos.exceptions.ResourceNotFoundException;
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
	
	public ProdutoVO getProduto(Long id) {
		System.out.println(id);
		Produto entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records for this id."));
		
		logger.info("Produto:  "+ entidade.getID() + " encontrado com sucesso!");
		var vo = mapper.toVO(entidade);
		return vo;
	}

	
	public ProdutoVO createProduto(ProdutoVO produto) {
		var entidade = mapper.toEntity(produto);
		System.out.println(produto);
		System.out.println(entidade);
		var vo = mapper.toVO(repository.save(entidade));
		
		return vo;
	}

	
	public ProdutoVO updateProduto(ProdutoVO produto) {
		Produto entidade = repository.findById(produto.getID())
				.orElseThrow(() -> new ResourceNotFoundException("No records for this id."));
		entidade.setNome(produto.getNome());
		entidade.setPreco(produto.getPreco());
		entidade.setTipo(produto.getTipo());
		
		var dto = mapper.toVO(repository.save(entidade));
		
		return dto;
		
	}

	
	public void deleteProduto(Long id) {
		var entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records for this id."));
		repository.delete(entidade);
	}


}
