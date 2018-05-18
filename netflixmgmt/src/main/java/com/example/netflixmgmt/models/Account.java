package com.example.netflixmgmt.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    @NotNull
    @NotBlank
    @Length(min = 3)
    private String username;

    @NotNull
    @NotBlank
    @Length(min = 3)
    private String password;

    @NotNull
    @NotBlank
    @Length(min = 5)
    private String email;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", targetEntity = ChangeRequest.class, cascade = CascadeType.ALL)
//    private List<ChangeRequest> changeRequestValues = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", targetEntity = Issue.class, cascade = CascadeType.ALL)
//    private List<Issue> issueValues = new ArrayList<>();

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(Long id, String username, String password, Role role, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Account() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Issue> getIssueValues() {
//        return issueValues;
//    }
//
//    public void setIssueValues(List<Issue> issueValues) {
//        this.issueValues = issueValues;
//    }
//
//    public List<ChangeRequest> getChangeRequestValues() {
//        return changeRequestValues;
//    }
//
//    public void setChangeRequestValues(List<ChangeRequest> changeRequestValues) {
//        this.changeRequestValues = changeRequestValues;
//    }
}
