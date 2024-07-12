package br.com.carlos.dto;

import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public record UsuarioDTO(
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		UUID user_Id,
		@Column(name = "name", nullable = false, length = 50)
		String name,
		@Column(name = "email", nullable = false, length = 50)
		String email) {

}
