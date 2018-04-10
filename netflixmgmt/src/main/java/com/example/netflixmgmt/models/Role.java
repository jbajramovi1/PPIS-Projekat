package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    public Role(Long id, String title, List<Account> accountList) {
        this.id = id;
        this.title = title;
        this.accountList=accountList;
    }

    public Role() {

    }

    private String title;

    @OneToMany(mappedBy = "role", targetEntity = Account.class, cascade = CascadeType.ALL)
    private List<Account> accountList = new ArrayList<>();

    public List<Account> getUserList() {
        return accountList;
    }

    public void setUserList(List<Account> accountListList) {
        this.accountList=accountList;
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
