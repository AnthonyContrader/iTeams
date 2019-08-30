package com.project.contrader.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Feedback entity.
 */
public class FeedbackDTO implements Serializable {

    private Long id;

    @NotNull
    private String sportName;

    @NotNull
    private String creatorName;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer rate;

    private Long sportId;

    private Long feedsportId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public Long getFeedsportId() {
        return feedsportId;
    }

    public void setFeedsportId(Long sportId) {
        this.feedsportId = sportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeedbackDTO feedbackDTO = (FeedbackDTO) o;
        if (feedbackDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), feedbackDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FeedbackDTO{" +
            "id=" + getId() +
            ", sportName='" + getSportName() + "'" +
            ", creatorName='" + getCreatorName() + "'" +
            ", rate=" + getRate() +
            ", sport=" + getSportId() +
            ", feedsport=" + getFeedsportId() +
            "}";
    }
}
