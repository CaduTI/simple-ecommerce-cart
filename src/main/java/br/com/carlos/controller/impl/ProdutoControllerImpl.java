package br.com.carlos.controller.impl;
 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import br.com.carlos.controller.ProdutoController;
import br.com.carlos.dto.ProdutoDTO;
import br.com.carlos.service.impl.ProdutoServiceImpl;

@RestController
@RequestMapping("/produto")
public class ProdutoControllerImpl implements ProdutoController{
	
	@Autowired
	ProdutoServiceImpl services;
	
	
	//Busca o produto pelo Id dele.
	@GetMapping(value = "/{id}")
	public ProdutoDTO getProduto(@PathVariable("id") UUID id) {
		return services.getProdutoDTO(id);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdutoDTO createProduto(@RequestBody ProdutoDTO produto) {
		return services.createProdutoDTO(produto);
	}
	
	//Atualiza o produto pelo Id dele.
	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdutoDTO updateProduto(@RequestBody ProdutoDTO produto) {
		return services.updateProdutoDTO(produto);
	}
	
	//Deleta o produto pelo Id dele.
	@DeleteMapping("/{id}")
	void deleteProduto(@PathVariable("id") UUID id) {
		services.deleteProdutoDTO(id);
	}
}
