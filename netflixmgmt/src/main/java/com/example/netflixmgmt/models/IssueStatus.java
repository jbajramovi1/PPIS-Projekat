package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class IssueStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueStatus", targetEntity = Issue.class, cascade = CascadeType.ALL)
//    private List<Issue> issueValues = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueStatus", targetEntity = IssueStatusLog.class, cascade = CascadeType.ALL)
//    private List<IssueStatusLog> issueStatusLogValues = new ArrayList<>();

    public IssueStatus() {
    }

    public IssueStatus(String name) {
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

//    public List<Issue> getIssueValues() {
//        return issueValues;
//    }
//
//    public void setIssueValues(List<Issue> issueValues) {
//        this.issueValues = issueValues;
//    }
//
//    public List<IssueStatusLog> getIssueStatusLogValues() {
//        return issueStatusLogValues;
//    }
//
//    public void setIssueStatusLogValues(List<IssueStatusLog> issueStatusLogValues) {
//        this.issueStatusLogValues = issueStatusLogValues;
//    }
}
