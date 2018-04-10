package com.example.netflixmgmt.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class ChangeRequestStatusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private Date date;

    @ManyToOne(targetEntity = ChangeRequest.class, fetch = FetchType.LAZY)
    private ChangeRequest changeRequest;

    @ManyToOne(targetEntity = ChangeRequestStatus.class, fetch = FetchType.LAZY)
    private ChangeRequestStatus changeRequestStatus;

    public ChangeRequestStatusLog() {
    }

    public ChangeRequestStatusLog(Date date, ChangeRequest changeRequest, ChangeRequestStatus changeRequestStatus) {
        this.date = date;
        this.changeRequest = changeRequest;
        this.changeRequestStatus = changeRequestStatus;
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

    public ChangeRequest getChangeRequest() {
        return changeRequest;
    }

    public void setChangeRequest(ChangeRequest changeRequest) {
        this.changeRequest = changeRequest;
    }

    public ChangeRequestStatus getChangeRequestStatus() {
        return changeRequestStatus;
    }

    public void setChangeRequestStatus(ChangeRequestStatus changeRequestStatus) {
        this.changeRequestStatus = changeRequestStatus;
    }
}
