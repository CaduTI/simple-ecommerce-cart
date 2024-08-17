package br.com.carlos.data.vo;

import br.com.carlos.model.Produto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({"idCarrinho","listaProdutos", "idUsuario", "precoTotal"})
public class CarrinhoVO extends RepresentationModel<CarrinhoVO> implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCarrinho;

	
	@Column(name = "listaProdutos", nullable = false, columnDefinition = "LONGBLOB")
	private List<Produto> listaProdutos;
	
	@JoinTable(
	        name = "carrinho",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	private Long idUsuario;
    
    @Column(name = "precoTotal", nullable = false)
	private Integer precoTotal;


	
	
	public CarrinhoVO (Long idCarrinho, List<Produto> listaProdutos, Long idUsuario, Integer precoTotal) {
		this.idCarrinho = idCarrinho;
		this.listaProdutos = listaProdutos;
		this.idUsuario = idUsuario;
		this.precoTotal = precoTotal;
	}
	
	public Long getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public List<Produto> getlistaProdutos() {
		return listaProdutos;
	}
	public void setlistaProdutos(List<Produto> list) {
		this.listaProdutos = list;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long getUser) {
		this.idUsuario = getUser;
	}
	public Integer getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Integer precoTotal) {
		this.precoTotal = precoTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCarrinho, idUsuario, listaProdutos, precoTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarrinhoVO other = (CarrinhoVO) obj;
		return Objects.equals(idCarrinho, other.idCarrinho) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(listaProdutos, other.listaProdutos) && Objects.equals(precoTotal, other.precoTotal);
	}
	
	
}
