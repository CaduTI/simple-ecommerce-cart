package br.com.carlos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.util.Media;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import br.com.carlos.data.vo.CarrinhoVO;
import br.com.carlos.data.vo.ProdutoVO;
import br.com.carlos.service.impl.CarrinhoServiceImpl;

@RestController
@RequestMapping("/api/carrinho/v1")
@Tag(name = "Carrinho", description = "Endpoint de Carrinho")
public class CarrinhoController {
	@Autowired
	private CarrinhoServiceImpl services;
	
	@GetMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Get Carrinho", description = "retorna um Carrinho de acordo com o Id passado.",
	tags = {"Carrinho"},
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
	public CarrinhoVO getCarrinho(@PathVariable("id") Long idCarrinho) {
		CarrinhoVO response = services.getCarrinho(idCarrinho);
		//return new ResponseEntity<CarrinhoDTO>(response,HttpStatus.OK);
		return response;
	}

	@PutMapping(value = "/{id}",
			consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Update Carrinho", description = "Atualiza um Carrinho de acordo com o Id passado.",
	tags = {"Carrinho"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CarrinhoVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public CarrinhoVO updateCarrinho(@RequestBody CarrinhoVO carrinho){

		return services.updateCarrinho(carrinho);

	}
	
	
	@PostMapping(consumes = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML},
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Post Carrinho", description = "Cria um Carrinho com as informações enviadas no request.",
	tags = {"Carrinho"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CarrinhoVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public CarrinhoVO createCarrinho(@RequestBody CarrinhoVO carrinho) {
		return services.createCarrinho(carrinho);
	}

	@DeleteMapping(value = "/{id}",
			produces = {Media.APPLICATION_JSON,Media.APPLICATION_XML, Media.APPLICATION_YML})
	@Operation(summary = "Delete Carrinho", description = "Deleta um Carrinho de acordo com o Id passado.",
	tags = {"Carrinho"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204"),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> deleteCarrinho(Long idCarrinho) {
		services.deleteCarrinho(idCarrinho);
		return ResponseEntity.noContent().build();
	}
}
