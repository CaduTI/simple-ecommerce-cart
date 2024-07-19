package br.com.carlos.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"idCarrinho","produtos", "idUsuario", "precoTotal"})
public record CarrinhoDTO(
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		UUID idCarrinho,
		String listaProdutos,
		UUID idUsuario,
 Integer precoTotal) {


	
}
