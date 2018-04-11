package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.Issue;
import com.example.netflixmgmt.models.IssueStatus;
import com.example.netflixmgmt.models.IssueType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIssueRepository extends PagingAndSortingRepository<Issue,Long> {
    Issue findIssueById(Long id);
    List<Issue> findIssueByIssueStatus(IssueStatus issueStatus);
    List<Issue> findIssueByIssueType(IssueType issueType);
    List<Issue> findAll();
}
