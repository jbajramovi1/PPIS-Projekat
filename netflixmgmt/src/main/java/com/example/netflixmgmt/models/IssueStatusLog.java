package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class IssueStatusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private Date date;

    @ManyToOne(targetEntity = Issue.class, fetch = FetchType.LAZY)
    private Issue issue;

    @ManyToOne(targetEntity = IssueStatus.class, fetch = FetchType.LAZY)
    private IssueStatus issueStatus;

    public IssueStatusLog() {
    }

    public IssueStatusLog(Date date, Issue issue, IssueStatus issueStatus) {
        this.date = date;
        this.issue = issue;
        this.issueStatus = issueStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }
}
