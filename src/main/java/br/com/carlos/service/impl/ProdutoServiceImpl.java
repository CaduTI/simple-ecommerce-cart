package br.com.carlos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.dto.ProdutoDTO;
import br.com.carlos.exceptions.ResourceNotFoundExcetion;
import br.com.carlos.mapper.DozerMapper;
import br.com.carlos.model.Produto;
import br.com.carlos.repository.ProdutoRepository;
import br.com.carlos.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	@Autowired
	ProdutoRepository repository;
	
	
	public List<ProdutoDTO> findall() {
		
		return DozerMapper.parseListObjects(repository.findAll(), ProdutoDTO.class);
	}

	
	public ProdutoDTO getProdutoDTO(Integer id) {
		var entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("No records for this id."));
		var dto = DozerMapper.parseObject(entidade, ProdutoDTO.class);
		return dto;
	}

	
	public ProdutoDTO createProdutoDTO(ProdutoDTO produto) {
		var entidade = DozerMapper.parseObject(produto, Produto.class);
		System.out.println(produto);
		System.out.println(entidade);
		var dto = DozerMapper.parseObject(repository.save(entidade), ProdutoDTO.class);
		
		
		return dto;
	}

	
	public ProdutoDTO updateProdutoDTO(ProdutoDTO produto) {
		Produto entidade = repository.findById(produto.getId())
				.orElseThrow(() -> new ResourceNotFoundExcetion("No records for this id."));
		entidade.setNome(produto.getNome());
		entidade.setPreco(produto.getPreco());
		entidade.setTipo(produto.getTipo());
		
		var dto = DozerMapper.parseObject(repository.save(entidade), ProdutoDTO.class);
		
		return dto;
		
	}

	
	public void deleteProdutoDTO(Integer id) {
		var entidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("No records for this id."));
		repository.delete(entidade);
	}


}
