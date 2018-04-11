package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.StatisticsType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStatisticsTypeRepository extends PagingAndSortingRepository<StatisticsType,Long> {
    StatisticsType findStatisticsTypeById(Long id);
    List<StatisticsType> findAll();
}
