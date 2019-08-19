package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.dto.UserDTO;
import it.contrader.model.Event;

import java.sql.Date;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {
	
	public Event findEventByCityAndAddressAndMatchtime(String city,String address, String matchtime);
	public List<Event> findAllByCityAndMatchtime(String city,String matchtime);
	public List<Event> findAllByMatchtime(String matchtime);
	public List<Event> findAllByUser(UserDTO user);
	public List<Event> findAllByCity(String city);
}