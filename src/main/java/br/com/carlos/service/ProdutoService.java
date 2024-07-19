package br.com.carlos.service;

import java.util.UUID;

import br.com.carlos.dto.ProdutoDTO;

public interface ProdutoService {
	//List<ProdutoDTO> findall();
	ProdutoDTO getProdutoDTO(UUID id);
	ProdutoDTO createProdutoDTO(ProdutoDTO produto);
	ProdutoDTO updateProdutoDTO(ProdutoDTO produto);
	void deleteProdutoDTO(UUID id);
}
