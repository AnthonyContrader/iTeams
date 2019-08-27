package it.contrader.model;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@Data
@Entity
@NoArgsConstructor
@Table(name = "message")

public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "text")
	private String text;
	
	//relazione messaggi inviati - user
	@ManyToOne
	@JoinColumn(name = "idSender", referencedColumnName = "id")
	private User sender;
	 
	//relazione messaggi ricevuti - user
	@ManyToOne
	@JoinColumn(name = "idReceiver", referencedColumnName = "id")
	private User receiver;
	

	
}
