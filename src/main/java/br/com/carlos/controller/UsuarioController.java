package br.com.carlos.controller;

import br.com.carlos.dto.UsuarioDTO;

public interface UsuarioController {
	UsuarioDTO getUsuario(Integer id);
	UsuarioDTO createUsuario(UsuarioDTO usuario);
	UsuarioDTO updateUsuario(UsuarioDTO usuario);
	void deleteUsuario(Integer id);
}
