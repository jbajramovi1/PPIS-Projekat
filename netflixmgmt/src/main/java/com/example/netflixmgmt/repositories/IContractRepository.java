package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IContractRepository extends PagingAndSortingRepository<Contract,Long> {
    Contract findContractById(Long id);
    List<Contract> findAll();
}
