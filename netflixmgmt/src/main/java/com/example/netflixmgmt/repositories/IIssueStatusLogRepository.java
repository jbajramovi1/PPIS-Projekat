package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.IssueStatusLog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIssueStatusLogRepository extends PagingAndSortingRepository<IssueStatusLog,Long> {
    IssueStatusLog findIssueStatusLogById(Long id);
    List<IssueStatusLog> findAll();
}
