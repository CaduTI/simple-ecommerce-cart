package br.com.carlos.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.carlos.common.ApiResponse;
import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.dto.CarrinhoDTORequest;
import br.com.carlos.dto.ProdutoDTO;
import br.com.carlos.service.impl.CarrinhoServiceImpl;

@RestController
@RequestMapping("/cart")
public class CarrinhoController {
	private static final Logger log = LoggerFactory.getLogger(CarrinhoController.class);
	@Autowired
	private CarrinhoServiceImpl services;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CarrinhoDTO getCarrinho(@PathVariable("id") UUID idCarrinho) {
		CarrinhoDTO response = services.getCarrinho(idCarrinho);
		//return new ResponseEntity<CarrinhoDTO>(response,HttpStatus.OK);
		return response;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> createPedido(@RequestBody CarrinhoDTO carrinho) {
		log.info("Carrinho dto recebido: "+carrinho.listaProdutos());
		CarrinhoDTO response = services.createCarrinho(carrinho);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Carrinho de id: "+ response.idCarrinho() +" criado com sucesso"),HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCarrinho(UUID idCarrinho) {
		services.deleteCarrinho(idCarrinho);
		return ResponseEntity.noContent().build();
	}
}
