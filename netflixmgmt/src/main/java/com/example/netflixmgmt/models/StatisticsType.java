package com.example.netflixmgmt.models;

import javax.persistence.*;

/**
 * Created by Siii on 4/8/2018.
 */
@Entity
public class StatisticsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    public StatisticsType() {
    }

    public StatisticsType(String name) {
        this.name = name;
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
}
