package com.example.netflixmgmt.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String description;
    private String client;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract", targetEntity = Component.class, cascade = CascadeType.ALL)
//    private List<Component> componentValues = new ArrayList<>();
    @ManyToOne(targetEntity = Component.class, fetch = FetchType.EAGER)
    private Component component;

    public Contract() {
    }

    public Contract(String name, String description, String client) {
        this.name = name;
        this.description = description;
        this.client = client;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    //    public List<Component> getComponentValues() {
//        return componentValues;
//    }
//
//    public void setComponentValues(List<Component> componentValues) {
//        this.componentValues = componentValues;
//    }
}
