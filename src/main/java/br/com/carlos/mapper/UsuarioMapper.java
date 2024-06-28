package br.com.carlos.mapper;

import org.springframework.stereotype.Service;

import br.com.carlos.dto.UsuarioDTO;
import br.com.carlos.model.Usuario;
@Service
public class UsuarioMapper {
	public UsuarioDTO convertEntityToVo(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setName(usuario.getName());
		dto.setEmail(usuario.getEmail());
		return dto;
	}
	
	
	public Usuario convertVoTOEntity(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		return entity;
	}
}
