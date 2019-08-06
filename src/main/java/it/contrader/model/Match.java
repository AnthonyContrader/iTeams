package it.contrader.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "sportname")
	@NotNull
	private String sportName;
	
	@Column(name = "username")
	@NotNull
	private String userName;
	
	@Column	(name = "rate")
	@NotNull
	private int rate;

	@Column(name = "city")
	@NotNull
	private String city;
	
	@Column(name = "address")
	@NotNull
	private String address;

	@NotNull
	@Column(name = "matchtime")
	private String matchtime;

	@Nullable
	@Column(name = "status")
	private Boolean status;

}