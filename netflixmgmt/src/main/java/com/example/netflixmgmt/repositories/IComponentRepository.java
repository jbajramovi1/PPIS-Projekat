package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.Component;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComponentRepository extends PagingAndSortingRepository<Component, Long> {
    Component findComponentById(Long id);
    List<Component> findAll();
}
