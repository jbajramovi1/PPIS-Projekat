package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.ChangeRequestStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChangeRequestStatusRepository extends PagingAndSortingRepository<ChangeRequestStatus,Long> {
    ChangeRequestStatus findChangeRequestStatusById(Long id);
    List<ChangeRequestStatus> findAll();
}
