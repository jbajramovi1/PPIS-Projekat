package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;


    @OneToMany(mappedBy = "user", targetEntity = UserRole.class, cascade = CascadeType.ALL)
    private List<UserRole> userRoleList = new ArrayList<>();

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id, String email, String password, List<UserRole> userRoleList) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userRoleList = userRoleList;
    }

    public User() {

    }
}
