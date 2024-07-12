package br.com.carlos.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name ="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "user_id")
	private UUID user_Id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	public Usuario() {
		
	}
	
	public Usuario(UUID Id, String Name, String Email) {
		this.user_Id = Id;
		this.name = Name;
		this.email = Email;
	}
	
	public UUID getId() {
		return user_Id;
	}

	public void setId(UUID userId) {
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
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && user_Id == other.user_Id && Objects.equals(name, other.name);
	}
	
	
}
