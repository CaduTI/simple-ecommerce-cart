package br.com.carlos.mapper;

import org.springframework.stereotype.Service;

import br.com.carlos.dto.UsuarioDTO;
import br.com.carlos.model.Usuario;
@Service
public class UsuarioMapper {
	
	public UsuarioDTO toDTO(Usuario usuario) {
		return  new UsuarioDTO(usuario.getId(),usuario.getName(), usuario.getEmail());
		
	}
	
	
	public Usuario toEntity(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		
		entity.setId(dto.user_Id());
		entity.setName(dto.name());
		entity.setEmail(dto.email());
		return entity;
	}
}
