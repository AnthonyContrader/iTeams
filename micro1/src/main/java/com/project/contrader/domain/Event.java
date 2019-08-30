package com.project.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Event.
 */
@Entity
@Table(name = "event")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "sport_name", nullable = false)
    private String sportName;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    @Column(name = "rate", nullable = false)
    private Integer rate;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Column(name = "matchtime", nullable = false)
    private String matchtime;

    @NotNull
    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JsonIgnoreProperties("eventsports")
    private Sport sport;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Sport eventsport;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public Event sportName(String sportName) {
        this.sportName = sportName;
        return this;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Integer getRate() {
        return rate;
    }

    public Event rate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getCity() {
        return city;
    }

    public Event city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public Event address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMatchtime() {
        return matchtime;
    }

    public Event matchtime(String matchtime) {
        this.matchtime = matchtime;
        return this;
    }

    public void setMatchtime(String matchtime) {
        this.matchtime = matchtime;
    }

    public Boolean isStatus() {
        return status;
    }

    public Event status(Boolean status) {
        this.status = status;
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Sport getSport() {
        return sport;
    }

    public Event sport(Sport sport) {
        this.sport = sport;
        return this;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Sport getEventsport() {
        return eventsport;
    }

    public Event eventsport(Sport sport) {
        this.eventsport = sport;
        return this;
    }

    public void setEventsport(Sport sport) {
        this.eventsport = sport;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        if (event.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), event.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Event{" +
            "id=" + getId() +
            ", sportName='" + getSportName() + "'" +
            ", rate=" + getRate() +
            ", city='" + getCity() + "'" +
            ", address='" + getAddress() + "'" +
            ", matchtime='" + getMatchtime() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}
