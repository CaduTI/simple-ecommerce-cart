package br.com.carlos.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import br.com.carlos.dto.UsuarioDTO;

public interface UsuarioController {
	UsuarioDTO getUsuario(UUID id);
	UsuarioDTO createUsuario(UsuarioDTO usuario);
	UsuarioDTO updateUsuario(UsuarioDTO usuario);
	ResponseEntity<?> deleteUsuario(UUID id);
}
