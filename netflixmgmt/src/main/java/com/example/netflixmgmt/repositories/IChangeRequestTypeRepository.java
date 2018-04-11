package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.ChangeRequestType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChangeRequestTypeRepository extends PagingAndSortingRepository<ChangeRequestType,Long> {
    ChangeRequestType findChangeRequestTypeById(Long id);
    List<ChangeRequestType> findAll();
}
