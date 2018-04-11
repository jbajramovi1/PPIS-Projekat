package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.ChangeRequestStatus;
import com.example.netflixmgmt.repositories.IChangeRequestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChangeRequestStatusService {

    @Autowired
    private IChangeRequestStatusRepository changeRequestStatusRepository;

    public ChangeRequestStatus createChangeRequestStatus(ChangeRequestStatus data){
        ChangeRequestStatus changeRequestStatus=new ChangeRequestStatus();
        changeRequestStatus.setName(data.getName());
        return changeRequestStatusRepository.save(changeRequestStatus);
    }

    public ChangeRequestStatus getById(Long id){
        return changeRequestStatusRepository.findChangeRequestStatusById(Long.valueOf(id));
    }

    public List<ChangeRequestStatus> getAll(){
        return changeRequestStatusRepository.findAll();
    }

    public void deleteById(Long id){
        changeRequestStatusRepository.deleteById(Long.valueOf(id));
    }

    public ChangeRequestStatus updateChangeRequestStatus(ChangeRequestStatus data,Long id){
        ChangeRequestStatus changeRequestStatus=changeRequestStatusRepository.findChangeRequestStatusById(Long.valueOf(id));
        if (data.getName()!=null) changeRequestStatus.setName(data.getName());
        return changeRequestStatusRepository.save(changeRequestStatus);
    }
}
