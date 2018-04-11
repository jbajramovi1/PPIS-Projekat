package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.AvailabilityType;
import com.example.netflixmgmt.repositories.IAvailabilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AvailabilityTypeService {

    @Autowired
    private IAvailabilityTypeRepository availabilityTypeRepository;

    public AvailabilityType createAvailabilityType(AvailabilityType data){
        AvailabilityType availabilityType=new AvailabilityType();
        availabilityType.setName(data.getName());
        availabilityType.setDescription(data.getDescription());
        return availabilityTypeRepository.save(availabilityType);
    }

    public AvailabilityType getById(Long id){
        return availabilityTypeRepository.findAvailabilityTypeById(Long.valueOf(id));
    }

    public List<AvailabilityType> getAll(){
        return availabilityTypeRepository.findAll();
    }

    public void deleteById(Long id){
        availabilityTypeRepository.deleteById(Long.valueOf(id));
    }

    public AvailabilityType updateAvailabilityType(AvailabilityType data,Long id){
        AvailabilityType availabilityType=availabilityTypeRepository.findAvailabilityTypeById(Long.valueOf(id));
        if (data.getName()!=null) availabilityType.setName(data.getName());
        if (data.getDescription()!=null) availabilityType.setDescription(data.getDescription());
        return availabilityTypeRepository.save(availabilityType);
    }
}
