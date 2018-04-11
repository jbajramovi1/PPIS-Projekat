package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.AvailabilityType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAvailabilityTypeRepository extends PagingAndSortingRepository<AvailabilityType,Long> {
    AvailabilityType findAvailabilityTypeById(Long id);
    List<AvailabilityType> findAll();
}
