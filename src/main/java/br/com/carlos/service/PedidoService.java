package br.com.carlos.service;

import java.util.List;

import br.com.carlos.model.Pedido;

public interface PedidoService {
	List<Pedido> getPedido();
	Pedido createPedido(Pedido pedido);
	Pedido updatePedido(Pedido pedido);
	void deletePedido(Integer id);
}
