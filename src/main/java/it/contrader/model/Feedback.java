package it.contrader.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "feedback")


public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*
	@NotNull
	@Column(name = "idSport")		
	private int idSport;
	*/
	
	@ManyToOne
	@JoinColumn(name = "idSport", referencedColumnName = "id")
	private Sport sport;
	
	/*
	@NotNull
	@Column(name = "idUser")
	private int idUser;
	*/
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idCreator", referencedColumnName = "id")
	private User creator;
		
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