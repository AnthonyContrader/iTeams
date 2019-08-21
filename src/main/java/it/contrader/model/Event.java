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
	
	
	/*@NotNull
	@Column(name = "sportName")
	private String sportName;*/
	
	
	//relazione user - sport
	@ManyToOne
<<<<<<< HEAD
	@JoinColumn(name = "idUser", referencedColumnName = "id")
=======
	@JoinColumn(name = "idUser", referencedColumnName = "id") */
>>>>>>> 6414a4c86b40d4d15c77f481819fef1b50173ff9
	private User user;
	
	@NotNull
	@Column(name = "userName")
	private String userName;
	
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
	private Boolean status;
		
	//relazione event - sport
	@ManyToOne(cascade = CascadeType.MERGE)
<<<<<<< HEAD
	@JoinColumn(name = "idSport", referencedColumnName = "id")
=======
	@JoinColumn(name = "idSport", referencedColumnName = "id")*/
>>>>>>> 6414a4c86b40d4d15c77f481819fef1b50173ff9
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
<<<<<<< HEAD
		  name = "invited_event", 
		  joinColumns = @JoinColumn(name = "event_id"), 
		  inverseJoinColumns = @JoinColumn(name = "user_id"))
		  private Set<User> invited;
=======
		name = "invited_event", 
		joinColumns = @JoinColumn(name = "event_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id"))*/
		private Set<User> invited;
>>>>>>> 6414a4c86b40d4d15c77f481819fef1b50173ff9
		
	//@ManyToMany(mappedBy = "joinEvent", cascade = CascadeType.MERGE)
	private Set<User> joiners;
	
<<<<<<< HEAD
	//relazione event - team
	@OneToMany(mappedBy="event", cascade = CascadeType.MERGE)
=======
	/*relazione event - team
	@OneToMany(mappedBy="event", cascade = CascadeType.MERGE)*/
>>>>>>> 6414a4c86b40d4d15c77f481819fef1b50173ff9
	private Set<Team> teams;
}