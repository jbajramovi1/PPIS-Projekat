package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    public Role(Long id, String title, List<UserRole> userRoleList) {
        this.id = id;
        this.title = title;
        this.userRoleList = userRoleList;
    }

    public Role() {

    }

    private String title;

    @OneToMany(mappedBy = "role", targetEntity = UserRole.class, cascade = CascadeType.ALL)
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
