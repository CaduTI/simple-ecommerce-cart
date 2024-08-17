package br.com.carlos.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;
import org.json.JSONObject;


@Entity
@Table(name = "carrinho")
@JsonPropertyOrder({"idCarrinho", "listaProdutos", "idUsuario", "precoTotal"})
public class Carrinho {
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


	
	
	
	public Carrinho() {
		
	}
	
	public Carrinho (List<Produto> listaProdutos, Long idUsuario, Integer precoTotal) {

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
	public List<Produto> getProdutos() {
		return listaProdutos;
	}
	public void setProdutos(List<Produto> list) {
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
		return Objects.hash(idCarrinho, listaProdutos, idUsuario, precoTotal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrinho other = (Carrinho) obj;
		return Objects.equals(idCarrinho, other.idCarrinho) && Objects.equals(listaProdutos, other.listaProdutos)
				&& Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(precoTotal, other.precoTotal);
	}
	
	
}
