package br.com.carlos.mapper;

import org.springframework.stereotype.Service;

import br.com.carlos.dto.ProdutoDTO;
import br.com.carlos.model.Produto;

@Service
public class ProdutoMapper {
	
	public ProdutoDTO toDTO(Produto produto) {
		return new ProdutoDTO(produto.getID(),produto.getNome(),produto.getPreco(),produto.getTipo());
	}
	
	
	public Produto toEntity(ProdutoDTO dto) {
		
		Produto entity = new Produto();
		
		entity.setID(dto.id());
		entity.setNome(dto.nome());
		entity.setPreco(dto.preco());
		entity.setTipo(dto.tipo());
		
		return entity;
	}
}
