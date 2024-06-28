package br.com.carlos.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "carrinho")
@JsonPropertyOrder({"idCarrinho","idProduto", "idUsuario", "precoTotal"})
public class Carrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID idCarrinho;
	

    @Column(name = "idProduto", nullable = false)
	private Integer idProduto;
    
    @Column(name = "idUsuario", nullable = false)
	private Integer idUsuario;
    
    @Column(name = "precoTotal", nullable = false)
	private Integer precoTotal;

    //	private String listProdutoString;
	
	
	
	
	public Carrinho() {
		
	}
	
	public Carrinho (Integer idProduto, Integer idUsuario, Integer precoTotal) {

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
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuarioInteger(Integer idUsuarioInteger) {
		this.idUsuario = idUsuarioInteger;
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
