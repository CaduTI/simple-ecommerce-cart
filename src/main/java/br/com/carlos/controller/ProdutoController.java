package br.com.carlos.controller;

import org.springframework.beans.factory.annotation.Autowired;
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


import br.com.carlos.data.vo.ProdutoVO;
import br.com.carlos.service.impl.ProdutoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/produto/v1")
@Tag(name = "Produto", description = "Endpoint de Produto")
public class ProdutoController {

	@Autowired
	ProdutoServiceImpl services;
	
	
	//Busca o produto pelo Id dele.
	@GetMapping(value = "/{id}")
	@Operation(summary = "Get Produto", description = "retorna um Produto de acordo com o Id passado.",
	tags = {"Produto"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ProdutoVO getProduto(@PathVariable("id") Long id) {
		ProdutoVO	response = services.getProduto(id);
		return response;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Post Carrinho", description = "Cria um Produto com as informações enviadas no request.",
	tags = {"Produto"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ProdutoVO createProduto(@RequestBody ProdutoVO produto) {
		return services.createProduto(produto);
		
	}
	
	//Atualiza o produto pelo Id dele.
	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update Carrinho", description = "Atualiza um Produto de acordo com o Id passado.",
	tags = {"Produto"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ProdutoVO updateProduto(@RequestBody ProdutoVO produto) {
		return services.updateProduto(produto);

	}
	
	//Deleta o produto pelo Id dele.
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Produto", description = "Deleta um Produto de acordo com o Id passado.",
	tags = {"Produto"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204"),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> deleteProduto(@PathVariable("id") Long id) {
		services.deleteProduto(id);
		return ResponseEntity.noContent().build();
		
	}
}
