package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.MessageRepository;
import it.contrader.dto.MessageDTO;
import it.contrader.model.Message;

@Service
public class MessageService extends AbstractService<Message, MessageDTO> {
	
	/*
	public MessageDTO findById(long id) {
		return converter.toDTO(((MessageRepository)repository.findById(id));
	}
	*/
	

}
