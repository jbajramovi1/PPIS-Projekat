package com.example.netflixmgmt.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class UserRole {

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
