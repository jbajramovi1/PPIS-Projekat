package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.ChangeRequest;
import com.example.netflixmgmt.models.ChangeRequestStatusLog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChangeRequestStatusLogRepository extends PagingAndSortingRepository<ChangeRequestStatusLog, Long> {
    ChangeRequestStatusLog findChangeRequestStatusLogById(Long id);
    List<ChangeRequestStatusLog> findAll();
}
