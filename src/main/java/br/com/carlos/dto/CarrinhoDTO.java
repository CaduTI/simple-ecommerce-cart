package br.com.carlos.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@JsonPropertyOrder({"idCarrinho","idProduto", "idUsuario", "precoTotal"})
public record CarrinhoDTO( 
		@GeneratedValue(strategy = GenerationType.UUID)
		UUID idCarrinho,
 Integer idProduto,
 Integer idUsuario,
 Integer precoTotal) {

}
