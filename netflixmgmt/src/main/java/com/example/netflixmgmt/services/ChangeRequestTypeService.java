package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.ChangeRequestType;
import com.example.netflixmgmt.repositories.IAvailabilityTypeRepository;
import com.example.netflixmgmt.repositories.IChangeRequestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChangeRequestTypeService {

    @Autowired
    private IChangeRequestTypeRepository changeRequestTypeRepository;

    public ChangeRequestType createChangeRequestType(ChangeRequestType data){
        ChangeRequestType changeRequestType=new ChangeRequestType();
        changeRequestType.setName(data.getName());
        changeRequestType.setDescription(data.getDescription());
        return changeRequestTypeRepository.save(changeRequestType);
    }

    public ChangeRequestType getById(Long id){
        return changeRequestTypeRepository.findChangeRequestTypeById(Long.valueOf(id));
    }

    public List<ChangeRequestType> getAll(){
        return changeRequestTypeRepository.findAll();
    }

    public void deleteById(Long id){
        changeRequestTypeRepository.deleteById(Long.valueOf(id));
    }

    public ChangeRequestType updateChangeRequestStatus(ChangeRequestType data,Long id){
        ChangeRequestType changeRequestType=changeRequestTypeRepository.findChangeRequestTypeById(Long.valueOf(id));
        if (data.getName()!=null) changeRequestType.setName(data.getName());
        if (data.getDescription()!=null) changeRequestType.setDescription(data.getDescription());
        return changeRequestTypeRepository.save(changeRequestType);
    }
}
