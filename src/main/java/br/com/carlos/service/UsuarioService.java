package br.com.carlos.service;

import java.util.UUID;

import br.com.carlos.dto.UsuarioDTO;

public interface UsuarioService {
	UsuarioDTO getUsuario(UUID id);
	UsuarioDTO createUsuario(UsuarioDTO usuario);
	UsuarioDTO updateUsuario(UsuarioDTO usuario);
	void deletarUsuario(UUID id);
}
