package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.ChangeRequestStatusLog;
import com.example.netflixmgmt.repositories.IChangeRequestStatusLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChangeRequestStatusLogService {

    @Autowired
    private IChangeRequestStatusLogRepository changeRequestStatusLogRepository;

    public ChangeRequestStatusLog createChangeRequestStatusLog(ChangeRequestStatusLog data){
        ChangeRequestStatusLog changeRequestStatusLog=new ChangeRequestStatusLog();
        changeRequestStatusLog.setChangeRequest(data.getChangeRequest());
        changeRequestStatusLog.setChangeRequestStatus(data.getChangeRequestStatus());
        changeRequestStatusLog.setDate(data.getDate());
        return changeRequestStatusLogRepository.save(changeRequestStatusLog);
    }

    public ChangeRequestStatusLog getById(Long id){
        return changeRequestStatusLogRepository.findChangeRequestStatusLogById(Long.valueOf(id));
    }

    public List<ChangeRequestStatusLog> getAll(){
        return changeRequestStatusLogRepository.findAll();
    }

    public void deleteById(Long id){
        changeRequestStatusLogRepository.deleteById(Long.valueOf(id));
    }


}

