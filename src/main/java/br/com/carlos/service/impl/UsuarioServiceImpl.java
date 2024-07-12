package br.com.carlos.service.impl;


import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.dto.UsuarioDTO;
import br.com.carlos.exceptions.ResourceNotFoundExcetion;
import br.com.carlos.mapper.UsuarioMapper;
import br.com.carlos.model.Usuario;
import br.com.carlos.repository.UsuarioRepository;
import br.com.carlos.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;

	private Logger logger = Logger.getLogger(UsuarioService.class.getName());
	
	
	public UsuarioDTO getUsuario(UUID id) {
		var entidade = repository.findById(id)
				.orElseThrow((() -> new ResourceNotFoundExcetion("No records found for this ID!")));
		
		UsuarioDTO dto = mapper.toDTO(entidade);

		logger.info("User "+dto.user_Id() +  " Founded with sucess!");
		return dto;
	}

	
	public UsuarioDTO createUsuario( UsuarioDTO usuario) {
		logger.info(usuario.email());
		var entidade = mapper.toEntity(usuario);
		logger.info("User Created with sucess!");
		var dto =  mapper.toDTO(repository.save(entidade));
		
		
		return dto;
	}

	
	public UsuarioDTO updateUsuario(UsuarioDTO usuario) {
		Usuario entidade = repository.findById(usuario.user_Id())
				.orElseThrow((() -> new ResourceNotFoundExcetion("No records found for this ID!")));
		
		entidade.setName(usuario.name());
		entidade.setEmail(usuario.email());
		
		var dto =  mapper.toDTO(repository.save(entidade));
		
		return dto;
	}
	
	public void deletarUsuario(UUID id) {
		Usuario entidade = repository.findById(id)
				.orElseThrow((() -> new ResourceNotFoundExcetion("No records found for this ID!")));
		
		repository.delete(entidade);
		
		
	}
	

}
