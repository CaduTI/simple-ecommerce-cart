package br.com.carlos.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idCarrinho","idProduto", "idUsuario", "precoTotal"})
public record CarrinhoDTO( UUID idCarrinho,
 Integer idProduto,
 Integer idUsuarioInteger,
 Integer precoTotal) {

}
