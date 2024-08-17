package br.com.carlos.data.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"id","nome", "preco", "tipo"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produto_id")
	private  Long id;
	@Column(name = "name", nullable = false, length = 50)
	private String nome;
	@Column(name = "price")
	private Integer  preco;
	@Column(name = "type", nullable = false, length = 50)
	private String tipo;
	
	public ProdutoVO() {
		
	}
	
	public ProdutoVO(Long id, String nome, Integer preco, String tipo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipo= tipo;
	}
	
	public Long getID() {
		return id;
	}
	public void setID(Long id) {
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
		ProdutoVO other = (ProdutoVO) obj;
		return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
				&& Objects.equals(tipo, other.tipo);
	}
	
	
}
