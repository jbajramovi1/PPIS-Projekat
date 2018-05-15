package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.ChangeRequest;
import com.example.netflixmgmt.models.ChangeRequestStatus;
import com.example.netflixmgmt.models.ChangeRequestType;
import com.example.netflixmgmt.repositories.IChangeRequestRepository;
import com.example.netflixmgmt.repositories.IChangeRequestTypeRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChangeRequestService {

    @Autowired
    private IChangeRequestRepository changeRequestRepository;

    @Autowired
    private IChangeRequestTypeRepository changeRequestTypeRepository;


    public ChangeRequest createChangeRequest(ChangeRequest data){
        ChangeRequest changeRequest=new ChangeRequest();
        changeRequest.setName(data.getName());
        changeRequest.setDescription(data.getDescription());
        changeRequest.setChangeRequestStatus(data.getChangeRequestStatus());
        changeRequest.setChangeRequestType(data.getChangeRequestType());
        changeRequest.setAccount(data.getAccount());
        changeRequest.setRevisionComment(data.getRevisionComment());
        return changeRequestRepository.save(changeRequest);
    }

    public ChangeRequest getById(Long id){
        return changeRequestRepository.findChangeRequestById(Long.valueOf(id));
    }

    public List<ChangeRequest> getByChangeRequestType(ChangeRequestType changeRequestType){
        return changeRequestRepository.findChangeRequestByChangeRequestType(changeRequestType);
    }

    public List<ChangeRequest> getByChangeRequestStatus(ChangeRequestStatus changeRequestStatus){
        return changeRequestRepository.findChangeRequestByChangeRequestStatus(changeRequestStatus);
    }

    public List<ChangeRequest> getAll(){
        return changeRequestRepository.findAll();
    }

    public void deleteById(Long id){
        changeRequestRepository.deleteById(Long.valueOf(id));
    }

    public ChangeRequest updateChangeRequest(ChangeRequest data,Long id){
        ChangeRequest changeRequest=changeRequestRepository.findChangeRequestById(Long.valueOf(id));
        if (data.getName()!=null) changeRequest.setName(data.getName());
        if (data.getDescription()!=null) changeRequest.setDescription(data.getDescription());
        if (data.getChangeRequestStatus()!=null) changeRequest.setChangeRequestStatus(data.getChangeRequestStatus());
        if (data.getChangeRequestType()!=null) changeRequest.setChangeRequestType(data.getChangeRequestType());
        if (data.getAccount()!=null) changeRequest.setAccount(data.getAccount());
        if (data.getRevisionComment()!=null) changeRequest.setRevisionComment(data.getRevisionComment());
        return changeRequestRepository.save(changeRequest);
    }

    public Map<String, Integer> getChangeRequestStatistics(){
        Map<String, Integer> results = new LinkedHashMap<>();
        
        results.put("All requests", changeRequestRepository.findAll().size());

        for (ChangeRequestType changeRequestType:
                changeRequestTypeRepository.findAll()) {
            results.put(changeRequestType.getName(),
                    changeRequestRepository.findChangeRequestByChangeRequestType(changeRequestType).size());
            
        }

        return results;

    }
}
