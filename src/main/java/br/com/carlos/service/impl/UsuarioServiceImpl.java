package br.com.carlos.service.impl;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.dto.UsuarioDTO;
import br.com.carlos.exceptions.ResourceNotFoundExcetion;
import br.com.carlos.mapper.DozerMapper;
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
	public UsuarioDTO getUsuario(Integer id) {
		var entidade = repository.findById(id)
				.orElseThrow((() -> new ResourceNotFoundExcetion("No records found for this ID!")));
		
		System.out.println(entidade.getId());
		System.out.println(entidade.getName());
		
		UsuarioDTO dto = DozerMapper.parseObject(entidade, UsuarioDTO.class);
		System.out.println(dto.getId());
		System.out.println(dto.getName());

		logger.info("Id:"+ dto.getId() + "e nome: "+ dto.getName());
		return dto;
	}

	
	public UsuarioDTO createUsuario( UsuarioDTO usuario) {
		var entidade = mapper.convertVoTOEntity(usuario);
		var dto =  mapper.convertEntityToVo(repository.save(entidade));
		
		
		return dto;
	}

	
	public UsuarioDTO updateUsuario(UsuarioDTO usuario) {
		//Usuario entidade = repository.findById(usuario.getId()).get();
		Usuario entidade = repository.findById(usuario.getId())
				.orElseThrow((() -> new ResourceNotFoundExcetion("No records found for this ID!")));
		
		entidade.setName(usuario.getName());
		entidade.setEmail(usuario.getEmail());
		
		var dto =  mapper.convertEntityToVo(repository.save(entidade));
		
		return dto;
	}
	
	public void deletarUsuario(Integer id) {
		Usuario entidade = repository.findById(id)
				.orElseThrow((() -> new ResourceNotFoundExcetion("No records found for this ID!")));
		System.out.println(entidade.getId());
		repository.delete(entidade);
		
		
	}
	

}
