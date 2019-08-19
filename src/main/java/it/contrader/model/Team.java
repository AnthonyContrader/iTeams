package it.contrader.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Team {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	/*
	@Column(name = "idSport")
	@NotNull
	private int idSport;
		
	@Column(name = "players")
	@NotNull
	private int players;
	*/
	
	//relazione sport - evento
	@ManyToOne
	@JoinColumn(name = "idEvent", referencedColumnName = "id")
	private Event event;
	
	//relazione team - utenti
	@ManyToMany(mappedBy = "memberOf")
    private Set<User> components;
}