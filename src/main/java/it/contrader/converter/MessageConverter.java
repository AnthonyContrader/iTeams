package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.MessageDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Message;
import it.contrader.model.User;


@Component
public class MessageConverter extends AbstractConverter<Message,MessageDTO> {
	
	@Override
	public MessageDTO toDTO(Message message) {
		MessageDTO messageDTO = null;
		if (message !=null) {
			messageDTO = new MessageDTO();
			messageDTO.setId(message.getId());
			messageDTO.setText(message.getText());
			UserConverter uc= new UserConverter();
			messageDTO.setSender(uc.toDTOS((message.getSender())));
			messageDTO.setReceiver(uc.toDTOS((message.getReceiver())));
			
		}
		return messageDTO;
	}
	
	
	@Override
	public Message toEntity(MessageDTO messageDTO) {
		Message message = null;
		if (messageDTO !=null) {
			message = new Message ();
			message.setId(messageDTO.getId());
			message.setText(messageDTO.getText());
			UserConverter uc= new UserConverter();
			message.setSender(uc.toEntityS(messageDTO.getSender()));
			message.setReceiver(uc.toEntityS(messageDTO.getReceiver()));
		}
		return message;
		
	}
	
	@Override
	public Message toEntityS(MessageDTO messageDTO) {
		Message message = null;
		if (messageDTO !=null) {
			message = new Message ();
			message.setId(messageDTO.getId());
			message.setText(messageDTO.getText());
			UserConverter uc= new UserConverter();
			message.setSender(uc.toEntityS(messageDTO.getSender()));
			message.setReceiver(uc.toEntityS(messageDTO.getReceiver()));
		}
		return message;
	}

	@Override
	public MessageDTO toDTOS(Message message) {
		MessageDTO messageDTO = null;
		if (message !=null) {
			messageDTO = new MessageDTO();
			messageDTO.setId(message.getId());
			messageDTO.setText(message.getText());
			UserConverter uc= new UserConverter();
			messageDTO.setSender(uc.toDTOS((message.getSender())));
			messageDTO.setReceiver(uc.toDTOS((message.getReceiver())));
			
		}
		return messageDTO;
	
	
	}
	
}
