package br.com.carlos.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.data.vo.ProdutoVO;
import br.com.carlos.data.vo.UsuarioVO;
import br.com.carlos.service.impl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/usuario/v1")
@Tag(name = "Usuario", description = "Endpoint de Usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl services;
	// com a anotação @CrossOrigin podemos definir quais  outras aplicações podem consumir informações de nossa API. Ref: https://www.alura.com.br/artigos/como-resolver-erro-de-cross-origin-resource-sharing?srsltid=AfmBOoqRBK78QLsD6H_3tkgzqcC_mn4KCR-ShLFNtwC305TGEiJZcgJW
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get Usuario", description = "retorna um Produto de acordo com o Id passado.",
	tags = {"Usuario"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public UsuarioVO getUsuario(@PathVariable(value = "id") Long id) {
		return services.getUsuario(id);
	}

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Post Usuario", description = "Cria um Usuario com as informações enviadas no request.",
	tags = {"Usuario"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public UsuarioVO createUsuario(@RequestBody UsuarioVO usuario) {
		return services.createUsuario(usuario);
	}

	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Update Usuario", description = "Atualiza um Usuario de acordo com o Id passado.",
	tags = {"Usuario"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = {@Content(
							mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public UsuarioVO updateUsuario(@RequestBody UsuarioVO usuario) {
		return services.updateUsuario(usuario);
	}

	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete Usuario", description = "Deleta um Usuario de acordo com o Id passado.",
	tags = {"Usuario"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204"),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") Long id) {
		services.deletarUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
