package br.com.carlos.dto;

import br.com.carlos.model.Produto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({"idCarrinho","listaProdutos", "idUsuario", "precoTotal"})
public record CarrinhoDTORequest(
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		UUID idCarrinho,
		List<Produto> listaProdutos,
		UUID idUsuario,
 Integer precoTotal) {


	
}
