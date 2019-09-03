package com.project.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Sport.
 */
@Entity
@Table(name = "sport")
public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "players", nullable = false)
    private Integer players;

    @OneToMany(mappedBy = "sport")
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "sport")
    private Set<Feedback> feeds = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Sport name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlayers() {
        return players;
    }

    public Sport players(Integer players) {
        this.players = players;
        return this;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Sport events(Set<Event> events) {
        this.events = events;
        return this;
    }

    public Sport addEvents(Event event) {
        this.events.add(event);
        event.setSport(this);
        return this;
    }

    public Sport removeEvents(Event event) {
        this.events.remove(event);
        event.setSport(null);
        return this;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Feedback> getFeeds() {
        return feeds;
    }

    public Sport feeds(Set<Feedback> feedbacks) {
        this.feeds = feedbacks;
        return this;
    }

    public Sport addFeeds(Feedback feedback) {
        this.feeds.add(feedback);
        feedback.setSport(this);
        return this;
    }

    public Sport removeFeeds(Feedback feedback) {
        this.feeds.remove(feedback);
        feedback.setSport(null);
        return this;
    }

    public void setFeeds(Set<Feedback> feedbacks) {
        this.feeds = feedbacks;
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
        Sport sport = (Sport) o;
        if (sport.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sport.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Sport{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", players=" + getPlayers() +
            "}";
    }
}
