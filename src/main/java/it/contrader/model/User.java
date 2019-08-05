package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class User {

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	@Column(name = "username")
	@NotNull
	private String username;

	@Column(name = "password")
	@NotNull
	private String password;

	
}
