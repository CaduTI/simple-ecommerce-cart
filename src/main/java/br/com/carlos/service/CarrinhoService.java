package br.com.carlos.service;

import br.com.carlos.data.vo.CarrinhoVO;


public interface CarrinhoService {
	public CarrinhoVO getCarrinho(Long id);
	public CarrinhoVO updateCarrinho(CarrinhoVO carrinho);
	public CarrinhoVO createCarrinho(CarrinhoVO carrinho);
	void deleteCarrinho(Long id);
	public Integer calculoPrecototal(CarrinhoVO carrinho);
	
}
