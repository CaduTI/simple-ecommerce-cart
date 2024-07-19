package br.com.carlos.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name= "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "produto_id")
	private  UUID id;
	@Column(name = "name", nullable = false, length = 50)
	private String nome;
	@Column(name = "price")
	private Integer  preco;
	@Column(name = "type", nullable = false, length = 50)
	private String tipo;
	
	public Produto() {
		
	}
	
	public Produto(UUID id, String nome, Integer preco, String tipo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipo= tipo;
	}
	
	public UUID getID() {
		return id;
	}
	public void setID(UUID id) {
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
