package br.com.carlos.service.impl;

import br.com.carlos.controller.CarrinhoController;
import br.com.carlos.exceptions.RequiredObjectIsNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.carlos.data.vo.CarrinhoVO;
import br.com.carlos.exceptions.ResourceNotFoundException;
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
	CarrinhoMapper mapper;
	
	private Logger logger = Logger.getLogger(CarrinhoService.class.getName());

	
	//pesquisa um carrinho de compras
	public CarrinhoVO getCarrinho(Long id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));

		CarrinhoVO dto = mapper.toVO(search);

		dto.add(linkTo(methodOn(CarrinhoController.class).getCarrinho(id)).withSelfRel());
        
		return dto;
	}
	
	// Atualiza os itens do carrinho
	public CarrinhoVO updateCarrinho(CarrinhoVO carrinho) {
		if(carrinho == null) throw new RequiredObjectIsNullException();

		Carrinho entidade = repository.findById(carrinho.getIdCarrinho())
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));
		
		//entidade.setIdProduto(carrinho.idProduto());
		entidade.setProdutos(carrinho.getlistaProdutos());
		entidade.setPrecoTotal(calculoPrecototal(carrinho));
		CarrinhoVO dto = mapper.toVO(repository.save(entidade));
		dto.add(linkTo(methodOn(CarrinhoController.class).updateCarrinho(carrinho)).withSelfRel());

		return dto;
	}
	
	//cria um carrinho de compras de acordo com as informações do usuário e produto
	public CarrinhoVO createCarrinho(CarrinhoVO carrinho) {
		if(carrinho == null) throw new RequiredObjectIsNullException();

		Carrinho entidade = mapper.toEntity(carrinho);
		
		entidade.setProdutos(carrinho.getlistaProdutos());
		entidade.setIdUsuario(carrinho.getIdUsuario());
		entidade.setPrecoTotal(calculoPrecototal(carrinho));
				
		CarrinhoVO dto = mapper.toVO(repository.save(entidade));

		logger.info("Criando carrinho com o Id: " +carrinho.getIdCarrinho());
		dto.add(linkTo(methodOn(CarrinhoController.class).createCarrinho(carrinho)).withSelfRel());

		return dto;
	}

	//deleta o carrinho desejado
	public void deleteCarrinho(Long id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carrinho não encontrado."));
		
		repository.delete(search);
		
	}
	
	
	//calcula o preço total de acordo com a soma dos valores dos produtos
	public Integer calculoPrecototal(CarrinhoVO carrinho){
		Integer total = 0;

		for (int i = 0; i!= carrinho.getlistaProdutos().toArray().length; i++){
			total += carrinho.getlistaProdutos().get(i).getPreco();
		}

		return total;
	}

}
