package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class IssueType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueType", targetEntity = Issue.class, cascade = CascadeType.ALL)
    private List<Issue> issueValues = new ArrayList<>();

    public IssueType() {
    }

    public IssueType(String name, String description) {
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

    public List<Issue> getIssueValues() {
        return issueValues;
    }

    public void setIssueValues(List<Issue> issueValues) {
        this.issueValues = issueValues;
    }
}
