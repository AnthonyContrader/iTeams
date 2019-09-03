package com.project.contrader.service.mapper;

import com.project.contrader.domain.*;
import com.project.contrader.service.dto.EventDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Event and its DTO EventDTO.
 */
@Mapper(componentModel = "spring", uses = {SportMapper.class})
public interface EventMapper extends EntityMapper<EventDTO, Event> {

    @Mapping(source = "sport.id", target = "sportId")
    @Mapping(source = "sport.name", target = "sportName")
    EventDTO toDto(Event event);

    @Mapping(source = "sportId", target = "sport")
    Event toEntity(EventDTO eventDTO);

    default Event fromId(Long id) {
        if (id == null) {
            return null;
        }
        Event event = new Event();
        event.setId(id);
        return event;
    }
}
