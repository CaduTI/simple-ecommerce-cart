package br.com.carlos.service.impl;

import java.util.UUID;

import br.com.carlos.dto.CarrinhoDTORequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.exceptions.ResourceNotFoundExcetion;
import br.com.carlos.jsonparsing.Json;
import br.com.carlos.mapper.CarrinhoMapper;
import br.com.carlos.model.Carrinho;
import br.com.carlos.repository.CarrinhoRepository;
import br.com.carlos.service.CarrinhoService;
import java.util.logging.Logger;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(CarrinhoServiceImpl.class);
	@Autowired
	CarrinhoRepository repository;
	
	@Autowired
	UsuarioServiceImpl user;
	
	@Autowired	
	ProdutoServiceImpl produtoservices;
	
	@Autowired
	CarrinhoMapper mapper;
	
	private Logger logger = Logger.getLogger(CarrinhoService.class.getName());
	
	@Autowired
	Json parseJson;
	
	//pesquisa um carrinho de compras
	public CarrinhoDTO getCarrinho(UUID id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		
		//var parse = parseJson.toJson(search.getProdutos());
        CarrinhoDTO dto = mapper.toDTO(search);
        
		return dto;
	}
	
	// Atualiza os itens do carrinho
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

		/*entidade.setidProduto(getProd.id());
		entidade.setIdUsuario(carrinho.idUsuario());
		entidade.setProdutos(carrinho.listaProdutos().stream().map(produto -> {
			StringBuilder sb = new StringBuilder();
			
			sb.append("{");
            sb.append("  \"idProduto\": \"").append(produto.getID()).append("\",");
            sb.append("  \"nomeProduto\": \"").append(produto.getNome()).append("\",");
            sb.append("  \"tipoProduto\": \"").append(produto.getTipo()).append("\",");
            sb.append("  \"precoProduto\": ").append(produto.getPreco()).append("");
            sb.append("}");

			logger.info("String produto após tratativa: "+sb.toString());
            return sb.toString();
			
			
			
		}).toList());

		logger.info(entidade.getProdutos().get(0));

		*/
		entidade.setProdutos(carrinho.listaProdutos()
				
				
				);
		entidade.setIdUsuario(carrinho.idUsuario());
		entidade.setPrecoTotal(calculoPrecototal(carrinho));
				
		CarrinhoDTO dto = mapper.toDTO(repository.save(entidade));

		logger.info("Criando carrinho com o Id: " +carrinho.idCarrinho());
		logger.info("Produtos: "+dto.listaProdutos().toString());
		return dto;
	}

	//deleta o carrinho desejado
	public void deleteCarrinho(UUID id) {
		Carrinho search = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Carrinho não encontrado."));
		
		repository.delete(search);
		
	}
	
	
	//calcula o preço total de acordo com a soma dos valores dos produtos
	public Integer calculoPrecototal(CarrinhoDTO carrinho){
		Integer total = 0;

		for (int i = 0; i!= carrinho.listaProdutos().toArray().length; i++){
			total += carrinho.listaProdutos().get(i).getPreco();
		}

		return total;
	}
}
