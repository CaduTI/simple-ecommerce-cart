package br.com.carlos.controller.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.controller.CarrinhoController;
import br.com.carlos.dto.CarrinhoDTO;
import br.com.carlos.service.impl.CarrinhoServiceImpl;

@RestController
@RequestMapping("/cart")
public class CarrinhoControllerImpl implements CarrinhoController{
	@Autowired
	private CarrinhoServiceImpl services;
	
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CarrinhoDTO getCarrinho(@PathVariable("id") String idCarrinho) {
		// TODO Auto-generated method stub
		return services.getCarrinho(idCarrinho);
	}

	@PostMapping
	public CarrinhoDTO createPedido(CarrinhoDTO carrinho) {
		// TODO Auto-generated method stub
		return services.createCarrinho(carrinho);
	}

	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCarrinho(String idCarrinho) {
		services.deleteCarrinho(idCarrinho);
		return ResponseEntity.noContent().build();
	}

}
