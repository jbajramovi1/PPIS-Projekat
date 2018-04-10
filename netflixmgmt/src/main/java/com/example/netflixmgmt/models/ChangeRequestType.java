package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class ChangeRequestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "changeRequestType", targetEntity = ChangeRequest.class, cascade = CascadeType.ALL)
    private List<ChangeRequest> changeRequestValues = new ArrayList<>();

    public ChangeRequestType() {
    }

    public ChangeRequestType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChangeRequest> getChangeRequestValues() {
        return changeRequestValues;
    }

    public void setChangeRequestValues(List<ChangeRequest> changeRequestValues) {
        this.changeRequestValues = changeRequestValues;
    }
}
