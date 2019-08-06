package it.contrader.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer id;
	
	@Column(name = "sportname")
	@NotNull
	private String sportName;
	
	@Column(name = "username")
	@NotNull
	private String userName;
	
	@Column	(name = "rate")
	@NotNull
	private Integer rate;

	@Column(name = "city")
	@NotNull
	private String city;
	
	@Column(name = "address")
	@NotNull
	private String address;

	@NotNull
	@Column(name = "matchtime")
	private Date matchtime;

	@Nullable
	@Column(name = "status")
	private Boolean status;

}