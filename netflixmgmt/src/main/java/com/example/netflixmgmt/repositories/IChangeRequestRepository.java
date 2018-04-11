package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.ChangeRequest;
import com.example.netflixmgmt.models.ChangeRequestStatus;
import com.example.netflixmgmt.models.ChangeRequestType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChangeRequestRepository extends PagingAndSortingRepository<ChangeRequest,Long> {
    ChangeRequest findChangeRequestById(Long id);
    List<ChangeRequest> findAll();
    List<ChangeRequest> findChangeRequestByChangeRequestStatus(ChangeRequestStatus changeRequestStatus);
    List<ChangeRequest> findChangeRequestByChangeRequestType(ChangeRequestType changeRequestType);
}
