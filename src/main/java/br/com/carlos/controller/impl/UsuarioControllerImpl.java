package br.com.carlos.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.controller.UsuarioController;
import br.com.carlos.dto.UsuarioDTO;
import br.com.carlos.service.impl.UsuarioServiceImpl;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UsuarioControllerImpl implements UsuarioController{
	
	@Autowired
	UsuarioServiceImpl services;
	
	@GetMapping("/{id}")
	public UsuarioDTO getUsuario(@PathParam("id") Integer id) {
		return services.getUsuario(id);
	}

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuario) {
		return services.createUsuario(usuario);
	}

	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioDTO updateUsuario(@RequestBody UsuarioDTO usuario) {
		return services.updateUsuario(usuario);
	}

	@DeleteMapping
	public void deleteUsuario(@PathParam("id") Integer id) {
		services.deletarUsuario(id);
		System.out.println("apagado com sucesso");
	}

}
