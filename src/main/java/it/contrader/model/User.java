package it.contrader.model;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
//@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	public enum Usertype {
		ADMIN,
		USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private Usertype usertype;
	
	
	private boolean status;
	
	/*
	//user-eventicreati
	@OneToMany(mappedBy = "user", cascade= CascadeType.MERGE)
	private Set<Event> createdEvents;
	
	//user-eventi partecipa
	@ManyToMany(mappedBy= "joiners", cascade= CascadeType.MERGE)
	private Set<Event> joinEvent;
	
	//
	@ManyToMany(mappedBy="invited",cascade= CascadeType.MERGE)
	private Set<Event> invitedEvent;
	
	//relazione user team
	@ManyToMany(cascade= CascadeType.MERGE)
	@JoinTable(
	name="user_team", joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="team_id"))
	Set<Team> memberOf;*/
	
	//relazione user - sport
		@ManyToMany(targetEntity = Sport.class, cascade = {CascadeType.ALL})
		@JoinTable(
		  name = "user_sport", 
		  joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
		  inverseJoinColumns = @JoinColumn(name = "sport_id", referencedColumnName = "id"))
		  Set<Sport> like;
		
	/*//relazione user - feedback creati
	@OneToMany(mappedBy="creator", cascade = CascadeType.MERGE)
	private Set<Feedback> gived;*/
	
	
		//relazione user - feedback ricevuti
		@OneToMany(mappedBy="user", cascade = CascadeType.MERGE)
		private Set<Feedback> received;
		
		
		/*
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", usertype=" + usertype
					+ ", status=" + status + ", createdEvents=" + createdEvents + ", joinEvent=" + joinEvent
					+ ", invitedEvent=" + invitedEvent + ", memberOf=" + memberOf + ", like=" + like + ", gived=" + gived
					+ ", received=" + received + "]";
		}
	*/
}
