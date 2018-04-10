package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class ChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String description;
    private String revisionComment;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(targetEntity = ChangeRequestStatus.class, fetch = FetchType.LAZY)
    private ChangeRequestStatus changeRequestStatus;

    @ManyToOne(targetEntity = ChangeRequestType.class, fetch = FetchType.LAZY)
    private ChangeRequestType changeRequestType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "changeRequest", targetEntity = ChangeRequestStatusLog.class, cascade = CascadeType.ALL)
    private List<ChangeRequestStatusLog> changeRequestStatusLogValues = new ArrayList<>();

    public ChangeRequest() {
    }

    public ChangeRequest(String name, String description, String revisionComment, User user, ChangeRequestStatus changeRequestStatus, ChangeRequestType changeRequestType) {
        this.name = name;
        this.description = description;
        this.revisionComment = revisionComment;
        this.user = user;
        this.changeRequestStatus = changeRequestStatus;
        this.changeRequestType = changeRequestType;
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

    public String getRevisionComment() {
        return revisionComment;
    }

    public void setRevisionComment(String revisionComment) {
        this.revisionComment = revisionComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ChangeRequestStatusLog> getChangeRequestStatusLogValues() {
        return changeRequestStatusLogValues;
    }

    public void setChangeRequestStatusLogValues(List<ChangeRequestStatusLog> changeRequestStatusLogValues) {
        this.changeRequestStatusLogValues = changeRequestStatusLogValues;
    }

    public ChangeRequestStatus getChangeRequestStatus() {
        return changeRequestStatus;
    }

    public void setChangeRequestStatus(ChangeRequestStatus changeRequestStatus) {
        this.changeRequestStatus = changeRequestStatus;
    }

    public ChangeRequestType getChangeRequestType() {
        return changeRequestType;
    }

    public void setChangeRequestType(ChangeRequestType changeRequestType) {
        this.changeRequestType = changeRequestType;
    }
}
