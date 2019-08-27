package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.MessageDTO;
import it.contrader.service.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/message")

public class MessageController extends AbstractController<MessageDTO>{
	
	@Autowired
	private MessageService messageService;

}
