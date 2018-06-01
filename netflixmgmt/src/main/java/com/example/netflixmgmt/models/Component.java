package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(targetEntity = AvailabilityType.class, fetch = FetchType.LAZY)
    private AvailabilityType availabilityType;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "component", targetEntity = Issue.class, cascade = CascadeType.ALL)
//    private List<Issue> issueValues = new ArrayList<>();

    public Component() {
    }

    public Component(String name, String description, AvailabilityType availabilityType, Contract contract) {
        this.name = name;
        this.description = description;
        this.availabilityType = availabilityType;

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

    public AvailabilityType getAvailabilityType() {
        return availabilityType;
    }

    public void setAvailabilityType(AvailabilityType availabilityType) {
        this.availabilityType = availabilityType;
    }


//    public List<Issue> getIssueValues() {
//        return issueValues;
//    }
//
//    public void setIssueValues(List<Issue> issueValues) {
//        this.issueValues = issueValues;
//    }
}
