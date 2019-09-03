package com.project.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Feedback.
 */
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "creator_name", nullable = false)
    private String creatorName;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "rate", nullable = false)
    private Integer rate;

    @ManyToOne
    @JsonIgnoreProperties("feeds")
    private Sport sport;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public Feedback creatorName(String creatorName) {
        this.creatorName = creatorName;
        return this;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getRate() {
        return rate;
    }

    public Feedback rate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Sport getSport() {
        return sport;
    }

    public Feedback sport(Sport sport) {
        this.sport = sport;
        return this;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
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
        Feedback feedback = (Feedback) o;
        if (feedback.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), feedback.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Feedback{" +
            "id=" + getId() +
            ", creatorName='" + getCreatorName() + "'" +
            ", rate=" + getRate() +
            "}";
    }
}
