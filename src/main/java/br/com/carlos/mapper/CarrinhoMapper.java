package br.com.carlos.mapper;

import org.springframework.stereotype.Service;

import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.model.Carrinho;


@Service
public class CarrinhoMapper {
	public CarrinhoDTO toDTO(Carrinho carrinho) {
		return new CarrinhoDTO(carrinho.getIdCarrinho(),carrinho.getProdutos(), carrinho.getIdUsuario(), carrinho.getPrecoTotal());
	}
	
	public Carrinho toEntity(CarrinhoDTO dto) {
		Carrinho carrinho = new Carrinho();
		
		//UUID idCarrinho = dto.idCarrinho() != null ? dto.idCarrinho() : UUID.randomUUID();
		//carrinho.setIdCarrinho(idCarrinho);
		carrinho.setIdCarrinho(dto.idCarrinho());
		
		
		
		return carrinho;
	}
	
	
}
