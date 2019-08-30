package com.project.contrader.service.mapper;

import com.project.contrader.domain.*;
import com.project.contrader.service.dto.FeedbackDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Feedback and its DTO FeedbackDTO.
 */
@Mapper(componentModel = "spring", uses = {SportMapper.class})
public interface FeedbackMapper extends EntityMapper<FeedbackDTO, Feedback> {

    @Mapping(source = "sport.id", target = "sportId")
    @Mapping(source = "feedsport.id", target = "feedsportId")
    FeedbackDTO toDto(Feedback feedback);

    @Mapping(source = "sportId", target = "sport")
    @Mapping(source = "feedsportId", target = "feedsport")
    Feedback toEntity(FeedbackDTO feedbackDTO);

    default Feedback fromId(Long id) {
        if (id == null) {
            return null;
        }
        Feedback feedback = new Feedback();
        feedback.setId(id);
        return feedback;
    }
}
