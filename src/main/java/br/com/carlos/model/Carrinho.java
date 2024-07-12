package br.com.carlos.model;

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


@Entity
@Table(name = "carrinho")
@JsonPropertyOrder({"idCarrinho","idProduto", "idUsuario", "precoTotal"})
public class Carrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idCarrinho;
	
	@JoinTable(
	        name = "carrinho",
	        joinColumns = @JoinColumn(name = "produto_id"),
	        inverseJoinColumns = @JoinColumn(name = "produto_id")
	    )
	private UUID idProduto;
	
	
	@JoinTable(
	        name = "carrinho",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	private UUID idUsuario;
    
    @Column(name = "precoTotal", nullable = false)
	private Integer precoTotal;


	
	
	
	public Carrinho() {
		
	}
	
	public Carrinho (UUID idProduto, UUID idUsuario, Integer precoTotal) {

	this.idProduto = idProduto;
	this.idUsuario = idUsuario;
	this.precoTotal = precoTotal;
	}
	
	public UUID getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(UUID idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public UUID getidProduto() {
		return idProduto;
	}
	public void setidProduto(UUID idProduto) {
		this.idProduto = idProduto;
	}
	public UUID getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(UUID getUser) {
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
		return Objects.hash(idCarrinho, idProduto, idUsuario, precoTotal);
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
		return Objects.equals(idCarrinho, other.idCarrinho) && Objects.equals(idProduto, other.idProduto)
				&& Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(precoTotal, other.precoTotal);
	}
	
	
}
