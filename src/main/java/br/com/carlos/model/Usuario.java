package br.com.carlos.model;

import java.io.Serializable;
import java.util.Objects;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "name", nullable = false, length = 50)
	private String Name;
	@Column(name = "email", nullable = false, length = 50)
	private String Email;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer Id, String Name, String Email) {
		this.Id = Id;
		this.Name = Name;
		this.Email = Email;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer userId) {
		this.Id = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Email, Id, Name);
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
		return Objects.equals(Email, other.Email) && Id == other.Id && Objects.equals(Name, other.Name);
	}
	
	
}
