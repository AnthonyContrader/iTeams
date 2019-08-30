package com.project.contrader.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Event entity.
 */
public class EventDTO implements Serializable {

    private Long id;

    @NotNull
    private String sportName;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer rate;

    @NotNull
    private String city;

    @NotNull
    private String address;

    @NotNull
    private String matchtime;

    @NotNull
    private Boolean status;

    private Long sportId;

    private Long eventsportId;

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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(String matchtime) {
        this.matchtime = matchtime;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public Long getEventsportId() {
        return eventsportId;
    }

    public void setEventsportId(Long sportId) {
        this.eventsportId = sportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EventDTO eventDTO = (EventDTO) o;
        if (eventDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), eventDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EventDTO{" +
            "id=" + getId() +
            ", sportName='" + getSportName() + "'" +
            ", rate=" + getRate() +
            ", city='" + getCity() + "'" +
            ", address='" + getAddress() + "'" +
            ", matchtime='" + getMatchtime() + "'" +
            ", status='" + isStatus() + "'" +
            ", sport=" + getSportId() +
            ", eventsport=" + getEventsportId() +
            "}";
    }
}
