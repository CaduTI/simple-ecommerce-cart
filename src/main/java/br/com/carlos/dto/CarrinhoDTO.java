package br.com.carlos.dto;

import java.util.List;
import java.util.UUID;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.carlos.model.Produto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"idCarrinho","listaProdutos", "idUsuario", "precoTotal"})
public record CarrinhoDTO(
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		UUID idCarrinho,
		List<Produto> listaProdutos,
		UUID idUsuario,
		Integer precoTotal) {


	
}
