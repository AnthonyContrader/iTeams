package it.contrader.dto;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see User
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private long id;
	
	private String username;
	
	private String password;

	private Usertype usertype;
	
	/*private boolean status;
	
	private Set<EventDTO> createdEventsDTO;
	
	private Set<EventDTO> joinEventDTO;
	
	private Set<EventDTO> invitedEventDTO;
	
	private Set<TeamDTO> memberOfDTO;
	
	private Set<SportDTO> likeDTO;
	
	private Set<FeedbackDTO> givedDTO;
	
	private Set<FeedbackDTO> receivedDTO;*/
/*
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", usertype=" + usertype
				+ ", status=" + status + ", createdEventsDTO=" + createdEventsDTO + ", joinEventDTO=" + joinEventDTO
				+ ", invitedEventDTO=" + invitedEventDTO + ", memberOfDTO=" + memberOfDTO + ", likeDTO=" + likeDTO
				+ ", givedDTO=" + givedDTO + ", receivedDTO=" + receivedDTO + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (createdEventsDTO == null) {
			if (other.createdEventsDTO != null)
				return false;
		} else if (!createdEventsDTO.equals(other.createdEventsDTO))
			return false;
		if (givedDTO == null) {
			if (other.givedDTO != null)
				return false;
		} else if (!givedDTO.equals(other.givedDTO))
			return false;
		if (id != other.id)
			return false;
		if (invitedEventDTO == null) {
			if (other.invitedEventDTO != null)
				return false;
		} else if (!invitedEventDTO.equals(other.invitedEventDTO))
			return false;
		if (joinEventDTO == null) {
			if (other.joinEventDTO != null)
				return false;
		} else if (!joinEventDTO.equals(other.joinEventDTO))
			return false;
		if (likeDTO == null) {
			if (other.likeDTO != null)
				return false;
		} else if (!likeDTO.equals(other.likeDTO))
			return false;
		if (memberOfDTO == null) {
			if (other.memberOfDTO != null)
				return false;
		} else if (!memberOfDTO.equals(other.memberOfDTO))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (receivedDTO == null) {
			if (other.receivedDTO != null)
				return false;
		} else if (!receivedDTO.equals(other.receivedDTO))
			return false;
		if (status != other.status)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usertype != other.usertype)
			return false;
		return true;
	}*/

	@Override
	public int hashCode() {
		return ThreadLocalRandom.current().nextInt(0, 999999999);
	}
	
	

}