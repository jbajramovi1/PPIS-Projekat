package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.IssueStatus;
import com.example.netflixmgmt.models.IssueStatusLog;
import com.example.netflixmgmt.repositories.IIssueStatusLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IssueStatusLogService {

    @Autowired
    private IIssueStatusLogRepository issueStatusLogRepository;

    public IssueStatusLog createIssueStatusLog(IssueStatusLog data){
        IssueStatusLog issueStatusLog=new IssueStatusLog();
        issueStatusLog.setDate(data.getDate());
        issueStatusLog.setIssue(data.getIssue());
        issueStatusLog.setIssueStatus(data.getIssueStatus());
        return issueStatusLogRepository.save(issueStatusLog);
    }

    public IssueStatusLog getById(Long id){
        return issueStatusLogRepository.findIssueStatusLogById(Long.valueOf(id));
    }

    public List<IssueStatusLog> getAll(){
        return issueStatusLogRepository.findAll();
    }

    public void deleteById(Long id){
        issueStatusLogRepository.deleteById(Long.valueOf(id));
    }


}
