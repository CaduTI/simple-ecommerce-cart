package br.com.carlos.service;

import br.com.carlos.data.vo.CarrinhoVO;
import br.com.carlos.mapper.CarrinhoMapper;
import br.com.carlos.model.Carrinho;
import br.com.carlos.repository.CarrinhoRepository;
import br.com.carlos.service.impl.CarrinhoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.when;


public class CarrinhoServiceTest {

    @Autowired
    CarrinhoService service;

    @Mock
    CarrinhoRepository repository;

    @Mock
    CarrinhoMapper mapper;

    @BeforeEach
    public void CarrinhoServiceTest(){
        repository = Mockito.mock(CarrinhoRepository.class);
        mapper = Mockito.mock(CarrinhoMapper.class);
        service = new CarrinhoServiceImpl();

    }

	@Test
	public void getCarrinhoTestSucesso(){
        Carrinho carrinhoMock = Mockito.mock(Carrinho.class);
        when(repository.findById(1L)).thenReturn(Optional.of(carrinhoMock));
        CarrinhoVO retorno = service.getCarrinho(1L);

        Assertions.assertNotNull(retorno.getIdCarrinho());
	}

}
