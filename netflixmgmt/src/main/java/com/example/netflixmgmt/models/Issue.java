package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private Date date;

    @ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(targetEntity = Component.class, fetch = FetchType.LAZY)
    private Component component;

    @ManyToOne(targetEntity = IssueStatus.class, fetch = FetchType.LAZY)
    private IssueStatus issueStatus;

    @ManyToOne(targetEntity = IssueType.class, fetch = FetchType.LAZY)
    private IssueType issueType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue", targetEntity = IssueStatusLog.class, cascade = CascadeType.ALL)
    private List<IssueStatusLog> issueStatusLogValues = new ArrayList<>();

    public Issue() {
    }

    public Issue(String name, Date date, Account account, Component component, IssueStatus issueStatus, IssueType issueType) {
        this.name = name;
        this.date = date;
        this.account=account;
        this.component = component;
        this.issueStatus = issueStatus;
        this.issueType = issueType;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account=account;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public List<IssueStatusLog> getIssueStatusLogValues() {
        return issueStatusLogValues;
    }

    public void setIssueStatusLogValues(List<IssueStatusLog> issueStatusLogValues) {
        this.issueStatusLogValues = issueStatusLogValues;
    }
}
