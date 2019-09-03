package com.project.contrader.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Event entity.
 */
public class EventDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Integer rate;

    @NotNull
    private String city;

    @NotNull
    private String address;

    @NotNull
    private Boolean status;

    @NotNull
    private ZonedDateTime matchtime;

    private Long sportId;

    private String sportName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ZonedDateTime getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(ZonedDateTime matchtime) {
        this.matchtime = matchtime;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
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
            ", rate=" + getRate() +
            ", city='" + getCity() + "'" +
            ", address='" + getAddress() + "'" +
            ", status='" + isStatus() + "'" +
            ", matchtime='" + getMatchtime() + "'" +
            ", sport=" + getSportId() +
            ", sport='" + getSportName() + "'" +
            "}";
    }
}
