package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.IssueType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIssueTypeRepository extends PagingAndSortingRepository<IssueType,Long> {
    IssueType findIssueTypeById(Long id);
    List<IssueType> findAll();
}
