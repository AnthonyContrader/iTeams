package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "sportName")		
	private String sportName;
	
	@NotNull
	@Column(name = "userName")
	private String userName;
	
	@NotNull
	@Column(name = "creatorName")
	private String creatorName;
	
	@NotNull
	@Column(name = "rate")
	private int rate;
}
