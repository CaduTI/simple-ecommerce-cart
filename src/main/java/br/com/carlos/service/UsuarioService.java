package br.com.carlos.service;

import java.util.UUID;

import br.com.carlos.data.vo.UsuarioVO;

public interface UsuarioService {
	UsuarioVO getUsuario(Long id);
	UsuarioVO createUsuario(UsuarioVO usuario);
	UsuarioVO updateUsuario(UsuarioVO usuario);
	void deletarUsuario(Long id);
}
