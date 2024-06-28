package br.com.carlos.controller.impl;


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
import br.com.carlos.controller.UsuarioController;
import br.com.carlos.dto.UsuarioDTO;
import br.com.carlos.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/user")
public class UsuarioControllerImpl implements UsuarioController{
	
	@Autowired
	UsuarioServiceImpl services;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO getUsuario(@PathVariable(value = "id") Integer id) {
		return services.getUsuario(id);
	}

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuario) {
		return services.createUsuario(usuario);
	}

	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO updateUsuario(@RequestBody UsuarioDTO usuario) {
		return services.updateUsuario(usuario);
	}

	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") Integer id) {
		services.deletarUsuario(id);
		System.out.println("apagado com sucesso");
		return ResponseEntity.noContent().build();
	}

}
