package br.com.carlos.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.carlos.model.Usuario;

public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private String Name;
	private String Email;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(int Id, String Name, String Email) {
		this.Id = Id;
		this.Name = Name;
		this.Email = Email;
	}
	
	public UsuarioDTO(Usuario usuario) {
		Id = usuario.getId();
		Name = usuario.getName();
		Email = usuario.getEmail();
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int userId) {
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
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(Email, other.Email) && Id == other.Id && Objects.equals(Name, other.Name);
	}
	
	
}
