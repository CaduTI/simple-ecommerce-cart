package br.com.carlos.data.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"user_id","name", "email"})
public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long user_Id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	public UsuarioVO() {
		
	}
	
	public UsuarioVO(Long Id, String Name, String Email) {
		this.user_Id = Id;
		this.name = Name;
		this.email = Email;
	}
	
	public Long getId() {
		return user_Id;
	}

	public void setId(Long userId) {
		this.user_Id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, user_Id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioVO other = (UsuarioVO) obj;
		return Objects.equals(email, other.email) && user_Id == other.user_Id && Objects.equals(name, other.name);
	}
	
	
}