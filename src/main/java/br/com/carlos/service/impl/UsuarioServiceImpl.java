package br.com.carlos.service.impl;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.data.vo.UsuarioVO;
import br.com.carlos.exceptions.ResourceNotFoundException;
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
	
	
	public UsuarioVO getUsuario(Long id) {
		Usuario entidade = repository.findById(id)
				.orElseThrow((() -> new ResourceNotFoundException("No records found for this ID!")));
		
		UsuarioVO vo = mapper.toVO(entidade);

		
		return vo;
	}

	
	public UsuarioVO createUsuario( UsuarioVO usuario) {
		logger.info(usuario.getEmail());
		var entidade = mapper.toEntity(usuario);
		logger.info("User Created with sucess!");
		var dto =  mapper.toVO(repository.save(entidade));
		
		
		return dto;
	}

	
	public UsuarioVO updateUsuario(UsuarioVO usuario) {
		Usuario entidade = repository.findById(usuario.getId())
				.orElseThrow((() -> new ResourceNotFoundException("No records found for this ID!")));
		
		entidade.setName(usuario.getName());
		entidade.setEmail(usuario.getEmail());
		
		var dto =  mapper.toVO(repository.save(entidade));
		
		return dto;
	}
	
	public void deletarUsuario(Long id) {
		Usuario entidade = repository.findById(id)
				.orElseThrow((() -> new ResourceNotFoundException("No records found for this ID!")));
		
		repository.delete(entidade);
		
		
	}
	

}
