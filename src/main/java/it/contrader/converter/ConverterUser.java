package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class ConverterUser {

	public static UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setStatus(user.isStatus());
			userDTO.setUsertype(user.getUsertype());
			/*userDTO.setCreatedEventsDTO(ConverterEvent.toSetDTO(user.getCreatedEvents()));
			userDTO.setJoinEventDTO(ConverterEvent.toSetDTO(user.getJoinEvent()));
			userDTO.setInvitedEventDTO(ConverterEvent.toSetDTO(user.getInvitedEvent()));
			userDTO.setMemberOfDTO(ConverterTeam.toSetDTO(user.getMemberOf()));
			userDTO.setGivedDTO(ConverterFeedback.toSetDTO(user.getGived()));
			userDTO.setReceivedDTO(ConverterFeedback.toSetDTO(user.getReceived()));
			userDTO.setLikeDTO(ConverterSport.toSetDTO(user.getLike()));*/
		}
		return userDTO;
	}

	public static User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setUsertype(userDTO.getUsertype());
			user.setStatus(userDTO.getStatus());
			/*user.setCreatedEvents(ConverterEvent.toSetEntity(userDTO.getCreatedEventsDTO()));
			user.setJoinEvent(ConverterEvent.toSetEntity(userDTO.getJoinEventDTO()));
			user.setInvitedEvent(ConverterEvent.toSetEntity(userDTO.getInvitedEventDTO()));
			user.setMemberOf(ConverterTeam.toSetEntity(userDTO.getMemberOfDTO()));
			user.setGived(ConverterFeedback.toSetEntity(userDTO.getGivedDTO()));
			user.setReceived(ConverterFeedback.toSetEntity(userDTO.getReceivedDTO()));
			user.setLike(ConverterSport.toSetEntity(userDTO.getLikeDTO()));*/
		}
		return user;
	}

	public static List<UserDTO> toListDTO(List<User> list) {
		List<UserDTO> listUserDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (User user : list) {
				listUserDTO.add(ConverterUser.toDTO(user));
			}
		}
		return listUserDTO;
	}

	public static List<User> toListEntity(List<UserDTO> listUserDTO) {
		List<User> list = new ArrayList<>();
		if (!listUserDTO.isEmpty()) {
			for (UserDTO userDTO : listUserDTO) {
				list.add(ConverterUser.toEntity(userDTO));
			}
		}
		return list;
	}
	
	public static Set<UserDTO> toSetDTO(Set<User> set) {
		Set<UserDTO> setUserDTO = new HashSet<>();
		if (!set.isEmpty()) {
			for (User user : set) {
				setUserDTO.add(ConverterUser.toDTO(user));
			}
		}
		return setUserDTO;
	}
	
	public static Set<User> toSetEntity(Set<UserDTO> setUserDTO) {
		Set<User> set = new HashSet<>();
		if (!setUserDTO.isEmpty()) {
			for (UserDTO userDTO : setUserDTO) {
				set.add(ConverterUser.toEntity(userDTO));
			}
		}
		return set;
	}
}
