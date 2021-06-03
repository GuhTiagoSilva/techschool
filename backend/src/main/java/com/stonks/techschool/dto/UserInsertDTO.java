package com.stonks.techschool.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.stonks.techschool.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Campo Obrigatório")
	@Size(min = 8, message = "Senha precisa ter no mínimo 8 caracteres")
	private String password;
	
	public UserInsertDTO() {
		
	}
	
	public UserInsertDTO(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
