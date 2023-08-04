package com.example.tutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String comment;
    private long tutorial_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tutorial_id", nullable = false, foreignKey = @ForeignKey(name = "tutorial_id"))
    @JsonIgnore
    private Tutorial tutorial;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getTutorial_id() {
        return tutorial_id;
    }

    public void setTutorial_id(long tutorial_id) {
        this.tutorial_id = tutorial_id;
    }
}
