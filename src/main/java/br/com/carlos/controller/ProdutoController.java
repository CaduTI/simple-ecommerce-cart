package br.com.carlos.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.common.ApiResponse;
import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.dto.ProdutoDTO;
import br.com.carlos.service.impl.ProdutoServiceImpl;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoServiceImpl services;
	
	
	//Busca o produto pelo Id dele.
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> getProduto(@PathVariable("id") UUID id) {
		ProdutoDTO	dto = services.getProdutoDTO(id);
		return new ResponseEntity<ProdutoDTO>(dto,HttpStatus.OK);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> createProduto(@RequestBody ProdutoDTO produto) {
		services.createProdutoDTO(produto);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.CREATED);
	}
	
	//Atualiza o produto pelo Id dele.
	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> updateProduto(@RequestBody ProdutoDTO produto) {
		services.updateProdutoDTO(produto);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
	}
	
	//Deleta o produto pelo Id dele.
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduto(@PathVariable("id") UUID id) {
		services.deleteProdutoDTO(id);
		return ResponseEntity.noContent().build();
	}
}
