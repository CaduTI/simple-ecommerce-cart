package br.com.carlos.controller;

import org.springframework.http.ResponseEntity;

import br.com.carlos.dto.UsuarioDTO;

public interface UsuarioController {
	UsuarioDTO getUsuario(Integer id);
	UsuarioDTO createUsuario(UsuarioDTO usuario);
	UsuarioDTO updateUsuario(UsuarioDTO usuario);
	ResponseEntity<?> deleteUsuario(Integer id);
}
