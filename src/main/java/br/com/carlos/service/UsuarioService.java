package br.com.carlos.service;

import br.com.carlos.dto.UsuarioDTO;

public interface UsuarioService {
	UsuarioDTO getUsuario(Integer id);
	UsuarioDTO createUsuario(UsuarioDTO usuario);
	UsuarioDTO updateUsuario(UsuarioDTO usuario);
	void deletarUsuario(Integer id);
}
