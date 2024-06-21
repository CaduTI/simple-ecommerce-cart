package br.com.carlos.service.impl;


import org.springframework.stereotype.Service;

import br.com.carlos.dto.UsuarioDTO;
import br.com.carlos.mapper.DozerMapper;
import br.com.carlos.model.Usuario;
import br.com.carlos.repository.UsuarioRepository;
import br.com.carlos.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository repository;

	
	public UsuarioDTO getUsuario(Integer id) {
		Usuario entidade = repository.findById(id).get();
		
		UsuarioDTO dto = new UsuarioDTO(entidade);
		return dto;
	}

	
	public UsuarioDTO createUsuario(UsuarioDTO usuario) {
		//Usuario entidade = repository.findById(usuario.getId()).get();
		Usuario entidade = DozerMapper.parseObject(usuario, Usuario.class);
		UsuarioDTO dto = DozerMapper.parseObject(entidade, UsuarioDTO.class);
		
		
		return dto;
	}

	
	public UsuarioDTO updateUsuario(UsuarioDTO usuario) {
		//Usuario entidade = repository.findById(usuario.getId()).get();
		Usuario entidade = DozerMapper.parseObject(usuario, Usuario.class);
		entidade.setName(usuario.getName());
		entidade.setEmail(usuario.getEmail());
		var dto = DozerMapper.parseObject(entidade, UsuarioDTO.class);
		return dto;
	}

	
	public void deletarUsuario(Integer id) {
		Usuario entidade = repository.findById(id).get();
		repository.delete(entidade);
		
		
	}
	

}
