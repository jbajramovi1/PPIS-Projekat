package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.StatisticsType;
import com.example.netflixmgmt.repositories.IStatisticsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatisticsTypeService {

    @Autowired
    private IStatisticsTypeRepository statisticsTypeRepository;

    public StatisticsType createStatisticsType(StatisticsType data){
        StatisticsType statisticsType=new StatisticsType();
        statisticsType.setName(data.getName());
        return statisticsTypeRepository.save(statisticsType);
    }

    public StatisticsType getById(Long id){
        return statisticsTypeRepository.findStatisticsTypeById(Long.valueOf(id));
    }

    public List<StatisticsType> getAll(){
        return statisticsTypeRepository.findAll();
    }

    public void deleteById(Long id){
        statisticsTypeRepository.deleteById(Long.valueOf(id));
    }

    public StatisticsType updateStatisticsType(StatisticsType data,Long id){
        StatisticsType statisticsType=statisticsTypeRepository.findStatisticsTypeById(Long.valueOf(id));
        if (data.getName()!=null) statisticsType.setName(data.getName());
        return statisticsTypeRepository.save(statisticsType);
    }
}
