package br.com.carlos.service;

import java.util.List;

import br.com.carlos.model.Produto;

public interface ProdutoService {
	List<Produto> getProduto();
	Produto createProduto(ProdutoService produto);
	Produto updateProduto(ProdutoService produto);
	void deleteProduto(Integer id);
}
