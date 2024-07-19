package br.com.carlos.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@JsonPropertyOrder({"id","nome","preco","tipo"})
public record ProdutoDTO(
		@Id
		@OneToMany
		@GeneratedValue(strategy = GenerationType.UUID)
		UUID id,
		@Column(name = "name", nullable = false, length = 50)
	    String nome,
	    @Column(name = "price", nullable = false)
	    Integer preco,
	    @Column(name = "type", nullable = false, length = 50)
		String tipo) {

}
