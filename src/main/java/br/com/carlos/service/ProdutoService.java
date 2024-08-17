package br.com.carlos.service;

import br.com.carlos.data.vo.ProdutoVO;

public interface ProdutoService {
	//List<ProdutoDTO> findall();
	ProdutoVO getProduto(Long id);
	ProdutoVO createProduto(ProdutoVO produto);
	ProdutoVO updateProduto(ProdutoVO produto);
	void deleteProduto(Long id);
}
