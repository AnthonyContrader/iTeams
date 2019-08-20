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

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feedback")


public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/*
	@NotNull
	@Column(name = "idSport")		
	private int idSport;
	*/
	
	@ManyToOne
	@JoinColumn(name = "idSport", referencedColumnName = "id")
	private Sport sport;
	
	/*
	@NotNull
	@Column(name = "idUser")
	private int idUser;
	*/
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idCreator", referencedColumnName = "id")
	private User creator;
		
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "user", joinColumns = @JoinColumn(name = "User",
	 * referencedColumnName = "id")) private Set<User> user;
	 */
	
	@NotNull
	@Column(name = "rate")
	private int rate;

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", sport=" + sport + ", user=" + user + ", creator=" + creator + ", rate=" + rate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + rate;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (id != other.id)
			return false;
		if (rate != other.rate)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}	
}