package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.IssueStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIssueStatusRepository extends PagingAndSortingRepository<IssueStatus,Long> {
    IssueStatus findIssueStatusById(Long id);
    List<IssueStatus> findAll();
}
