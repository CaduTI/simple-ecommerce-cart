package br.com.carlos.mapper;

import org.springframework.stereotype.Service;


import br.com.carlos.data.vo.ProdutoVO;
import br.com.carlos.model.Produto;

@Service
public class ProdutoMapper {
	
	public ProdutoVO toVO(Produto produto) {
		return new ProdutoVO(produto.getID(),produto.getNome(),produto.getPreco(),produto.getTipo());
	}
	
	
	public Produto toEntity(ProdutoVO vo) {
		
		Produto entity = new Produto();
		
		entity.setID(vo.getID());
		entity.setNome(vo.getNome());
		entity.setPreco(vo.getPreco());
		entity.setTipo(vo.getTipo());
		
		return entity;
	}
}
