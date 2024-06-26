package br.com.carlos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name= "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	@Column(nullable = false)
	private Integer preco;
	@Column(name = "tipo", nullable = false, length = 50)
	private String tipo;
	
	public Produto() {
		
	}
	
	public Produto(Integer id, String nome, Integer preco, String tipo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipo= tipo;
	}
	
	public Integer getID() {
		return id;
	}
	public void setID(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPreco() {
		return preco;
	}
	public void setPreco(Integer preco) {
		this.preco = preco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, preco, tipo);
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
		return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
				&& Objects.equals(tipo, other.tipo);
	}
	
	
}
