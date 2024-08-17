package br.com.carlos.mapper;

import org.springframework.stereotype.Service;

import br.com.carlos.data.vo.UsuarioVO;
import br.com.carlos.model.Usuario;
@Service
public class UsuarioMapper {
	
	public UsuarioVO toVO(Usuario usuario) {
		return  new UsuarioVO(usuario.getId(),usuario.getName(), usuario.getEmail());
		
	}
	
	
	public Usuario toEntity(UsuarioVO vo) {
		Usuario entity = new Usuario();
		
		entity.setId(vo.getId());
		entity.setName(vo.getName());
		entity.setEmail(vo.getEmail());
		return entity;
	}
}
