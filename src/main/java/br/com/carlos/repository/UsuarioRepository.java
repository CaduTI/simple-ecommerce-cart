package br.com.carlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
