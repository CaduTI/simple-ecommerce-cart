package br.com.carlos.mapper;

import org.springframework.stereotype.Service;


import br.com.carlos.data.vo.CarrinhoVO;
import br.com.carlos.model.Carrinho;


@Service
public class CarrinhoMapper {
	public CarrinhoVO toVO(Carrinho carrinho) {
		return new CarrinhoVO(carrinho.getIdCarrinho(),carrinho.getProdutos().stream().toList(), carrinho.getIdUsuario(), carrinho.getPrecoTotal());
	}
	
	public Carrinho toEntity(CarrinhoVO vo) {
		Carrinho carrinho = new Carrinho();
		
		//UUID idCarrinho = dto.idCarrinho() != null ? dto.idCarrinho() : UUID.randomUUID();
		//carrinho.setIdCarrinho(idCarrinho);
		carrinho.setIdCarrinho(vo.getIdCarrinho());
		carrinho.setProdutos(vo.getlistaProdutos());
		/* 
		 .stream().map(produto -> {
			return String.valueOf(produto).toString();
		}).toList());
		 */
		
		
		return carrinho;
	}
}
