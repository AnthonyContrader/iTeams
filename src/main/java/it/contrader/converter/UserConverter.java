package it.contrader.converter;

import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Feedback;
import it.contrader.model.User;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class UserConverter extends AbstractConverter<User,UserDTO> {
	
	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			System.out.println("nel converter user toDTO");
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setStatus(user.isStatus());
			userDTO.setUsertype(user.getUsertype());
				
//			userDTO.setCreatedEventsDTO(ConverterEvent.toSetDTO(user.getCreatedEvents()));
//			userDTO.setJoinEventDTO(ConverterEvent.toSetDTO(user.getJoinEvent()));
//			userDTO.setInvitedEventDTO(ConverterEvent.toSetDTO(user.getInvitedEvent()));
//			userDTO.setMemberOfDTO(ConverterTeam.toSetDTO(user.getMemberOf()));
//			userDTO.setGivedDTO(ConverterFeedback.toSetDTO(user.getGived()));
			Converter<Feedback, FeedbackDTO> fc = new FeedbackConverter ();
			userDTO.setReceived((Set<FeedbackDTO>) fc.toDTOSet(user.getReceived()));
//			userDTO.setLikeDTO(ConverterSport.toSetDTO(user.getLike()));
		}
		return userDTO;
	}
	
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			System.out.println("nel converter user toEntity");
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setUsertype(userDTO.getUsertype());
			user.setStatus(userDTO.isStatus());			
//			user.setCreatedEvents(ConverterEvent.toSetEntity(userDTO.getCreatedEventsDTO()));
//			user.setJoinEvent(ConverterEvent.toSetEntity(userDTO.getJoinEventDTO()));
//			user.setInvitedEvent(ConverterEvent.toSetEntity(userDTO.getInvitedEventDTO()));
//			user.setMemberOf(ConverterTeam.toSetEntity(userDTO.getMemberOfDTO()));
//			user.setGived(ConverterFeedback.toSetEntity(userDTO.getGivedDTO()));
			Converter<Feedback, FeedbackDTO> fc = new FeedbackConverter ();
			user.setReceived((Set<Feedback>) fc.toEntitySet(userDTO.getReceived()));
			//user.setReceived(ConverterFeedback.toSetEntity(userDTO.getReceivedDTO()));
//			user.setLike(ConverterSport.toSetEntity(userDTO.getLikeDTO()));
		}
		return user;
	}

	@Override
	public User toEntityS(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			System.out.println("nel converter semplificato user toEntity");
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			//userDTO.setPassword(user.getPassword());
			user.setUsertype(userDTO.getUsertype());
			user.setStatus(userDTO.isStatus());
		}
		return user;
	}

	@Override
	public UserDTO toDTOS(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			System.out.println("nel converter semplificato user toDTO");
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			System.out.println("ID> "+userDTO.getId());
			userDTO.setUsername(user.getUsername());
			System.out.println("ID> "+userDTO.getUsername());
			userDTO.setStatus(user.isStatus());
			System.out.println("ID> "+user.isStatus());
			userDTO.setUsertype(user.getUsertype());
			System.out.println("ID> "+user.getUsertype());
		}
		return userDTO;
	}
	
}