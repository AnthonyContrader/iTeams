package it.contrader.model;

import java.util.Set;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "idSport")
	private int idSport;
	
	@NotNull
	@Column(name = "idUser")
	private int idUser;
	
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "user", joinColumns = @JoinColumn(name = "User",
	 * referencedColumnName = "id")) private Set<User> user;
	 */
	@NotNull
	@Column(name = "rate")
	private int rate;
	

	
	
}
