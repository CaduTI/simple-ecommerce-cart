package br.com.carlos.controller.impl;



import java.util.UUID;

import br.com.carlos.dto.CarrinhoDTORequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.controller.CarrinhoController;
import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.service.impl.CarrinhoServiceImpl;

@RestController
@RequestMapping("/cart")
public class CarrinhoControllerImpl implements CarrinhoController{
	private static final Logger log = LoggerFactory.getLogger(CarrinhoControllerImpl.class);
	@Autowired
	private CarrinhoServiceImpl services;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CarrinhoDTO getCarrinho(@PathVariable("id") UUID idCarrinho) {
		return services.getCarrinho(idCarrinho);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CarrinhoDTO createPedido(@RequestBody CarrinhoDTORequest carrinho) {
		log.info("Carrinho dto recebido: "+carrinho.listaProdutos());
		return services.createCarrinho(carrinho);
	}

	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCarrinho(UUID idCarrinho) {
		services.deleteCarrinho(idCarrinho);
		return ResponseEntity.noContent().build();
	}

}
