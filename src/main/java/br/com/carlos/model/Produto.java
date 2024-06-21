package br.com.carlos.model;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private  int ID;
	private String nome;
	private Float preco;
	private String tipoProduto;
	
	public Produto() {
		
	}
	
	public Produto(int iD, String nome, Float preco, String tipoProduto) {
		ID = iD;
		this.nome = nome;
		this.preco = preco;
		this.tipoProduto = tipoProduto;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(ID, nome, preco, tipoProduto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return ID == other.ID && Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
				&& Objects.equals(tipoProduto, other.tipoProduto);
	}

}
