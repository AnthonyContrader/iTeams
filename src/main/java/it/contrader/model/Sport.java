package it.contrader.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@NamedQuery(name="Sport.findAll", query="SELECT s FROM Sport s")

public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "players")
	@NotNull
	private long players;
	
	//relazione sport - utenti
	@ManyToMany(/*targetEntity = User.class, */mappedBy = "like")
	private Set<User> likes;
	
	//relazione sport - evento
	@OneToMany(mappedBy="sport")
	private Set<Event> events;
		
	//relazione sport - feedback
	@OneToMany(mappedBy="sport")
	private Set<Feedback> sportfeed; 
	
}
