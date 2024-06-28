package br.com.carlos.mapper;

import org.springframework.stereotype.Service;

import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.model.Carrinho;

@Service
public class CarrinhoMapper {
	public CarrinhoDTO toDTO(Carrinho carrinho) {
		return new CarrinhoDTO(carrinho.getIdCarrinho(),carrinho.getIdProduto(),carrinho.getIdUsuario(), carrinho.getPrecoTotal());
	}
	
	public Carrinho toEntity(CarrinhoDTO dto) {
		Carrinho carrinho = new Carrinho();
		
		carrinho.setIdCarrinho(dto.idCarrinho());
		carrinho.setIdProduto(dto.idProduto());
		carrinho.setIdUsuarioInteger(dto.idUsuarioInteger());
		carrinho.setPrecoTotal(dto.precoTotal());
		
		return carrinho;
	}
}
