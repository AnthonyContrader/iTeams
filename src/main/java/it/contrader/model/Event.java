package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "sportName")
	private String sportName;
	
	@NotNull
	@Column(name = "userName")
	private String userName;
	
	@NotNull
	@Column(name = "rate")
	private int rate;
	
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
	@Column(name = "status")
	private Boolean  status;
	
}
