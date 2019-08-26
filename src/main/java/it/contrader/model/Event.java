package it.contrader.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
//@Data
@Entity
@NoArgsConstructor
@Table(name = "event")

public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	@Column(name = "sportName")
	private String sportName;
	
	
	//relazione user - sport
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private User creator;
	
	
	/*@NotNull
	@Column(name = "userName")
	private String userName;*/
	
	@NotNull
	@Column(name = "rate")
	private long rate;
	
	@NotNull
	@Column(name = "city")
	private String city;
	
	@NotNull
	@Column(name = "address")
	private String address;
	
	@NotNull
	@Column(name = "matchtime")
	private String matchtime;
	
	@NotNull
	@Column(name = "status", columnDefinition="tinyint(1) default 0")
	private boolean status;
		
/*	//relazione event - sport
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idSport", referencedColumnName = "id")
	private Sport sport;
	
	//relazione event - user
	
	//relazione user - evento
		@ManyToMany(cascade = CascadeType.MERGE)
		@JoinTable(
		  name = "user_event", 
		  joinColumns = @JoinColumn(name = "event_id"), 
		  inverseJoinColumns = @JoinColumn(name = "user_id"))
		  private Set<User> joiners;
	
		
	//relazione utenteInvitato - evento
		@ManyToMany(cascade = CascadeType.MERGE)
		@JoinTable(
		  name = "invited_event", 
		  joinColumns = @JoinColumn(name = "event_id"), 
		  inverseJoinColumns = @JoinColumn(name = "user_id"))
		  private Set<User> invited;
		
	//@ManyToMany(mappedBy = "joinEvent", cascade = CascadeType.MERGE)
//	private Set<User> joiners;
	
	//relazione event - team
	@OneToMany(mappedBy="event", cascade = CascadeType.MERGE)
	private Set<Team> teams;*/
}