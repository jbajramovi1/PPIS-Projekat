package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class ChangeRequestStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "changeRequestStatus", targetEntity = ChangeRequestStatusLog.class, cascade = CascadeType.ALL)
    private List<ChangeRequestStatusLog> changeRequestStatusLogValues = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "changeRequestStatus", targetEntity = ChangeRequest.class, cascade = CascadeType.ALL)
    private List<ChangeRequest> changeRequestValues = new ArrayList<>();

    public ChangeRequestStatus() {
    }

    public ChangeRequestStatus(String name) {
        this.name = name;
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

    public List<ChangeRequestStatusLog> getChangeRequestStatusLogValues() {
        return changeRequestStatusLogValues;
    }

    public void setChangeRequestStatusLogValues(List<ChangeRequestStatusLog> changeRequestStatusLogValues) {
        this.changeRequestStatusLogValues = changeRequestStatusLogValues;
    }

    public List<ChangeRequest> getChangeRequestValues() {
        return changeRequestValues;
    }

    public void setChangeRequestValues(List<ChangeRequest> changeRequestValues) {
        this.changeRequestValues = changeRequestValues;
    }
}
