package com.project.contrader.service.mapper;

import com.project.contrader.domain.*;
import com.project.contrader.service.dto.SportDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Sport and its DTO SportDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SportMapper extends EntityMapper<SportDTO, Sport> {


    @Mapping(target = "events", ignore = true)
    @Mapping(target = "feeds", ignore = true)
    Sport toEntity(SportDTO sportDTO);

    default Sport fromId(Long id) {
        if (id == null) {
            return null;
        }
        Sport sport = new Sport();
        sport.setId(id);
        return sport;
    }
}
