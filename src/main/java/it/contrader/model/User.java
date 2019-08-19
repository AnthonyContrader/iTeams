package it.contrader.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name = "username")
	@NotNull
	private String username;

	@Column(name = "password")
	@NotNull
	private String password;
	
	@Column(name = "usertype")
	@NotNull
	private String usertype;
	
	@Column(name = "status")
	@NotNull
	private boolean status;
	
	
	//relazione user - eventi creati
	@OneToMany(mappedBy="user", cascade = CascadeType.MERGE)
	private Set<Event> createdEvents;
		
	
	//relazione user - evento
//	@ManyToMany(cascade = CascadeType.MERGE)
//	@JoinTable(
//	  name = "user_event", 
//	  joinColumns = @JoinColumn(name = "user_id"), 
//	  inverseJoinColumns = @JoinColumn(name = "event_id"))
//	  Set<Event> joinEvent;
//	
	
	@ManyToMany(mappedBy = "joiners", cascade = CascadeType.MERGE)
	private Set<Event> joinEvent;
	
	@ManyToMany(mappedBy = "invited", cascade = CascadeType.MERGE)
	private Set<Event> invitedEvent;
	
	//relazione user - team
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
	  name = "user_team", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "team_id"))
	  Set<Team> memberOf;
	
	//relazione user - sport
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
	  name = "user_sport", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "sport_id"))
	  Set<Sport> like;
	
	//relazione user - feedback creati
	@OneToMany(mappedBy="creator", cascade = CascadeType.MERGE)
	private Set<Feedback> gived;
	
	//relazione user - feedback ricevuti
	@OneToMany(mappedBy="user", cascade = CascadeType.MERGE)
	private Set<Feedback> received;
	
}