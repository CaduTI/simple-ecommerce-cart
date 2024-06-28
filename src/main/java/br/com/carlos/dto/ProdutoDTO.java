package br.com.carlos.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@JsonPropertyOrder({"id","nome","preco","tipo"})
public class ProdutoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	@Column(nullable = false)
	private Integer preco;
	@Column(name = "tipo", nullable = false, length = 50)
	private String tipo;
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(Integer id, String nome, Integer preco, String tipo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipo= tipo;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
				&& Objects.equals(tipo, other.tipo);
	}

}
