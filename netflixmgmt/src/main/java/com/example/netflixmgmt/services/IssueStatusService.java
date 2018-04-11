package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Issue;
import com.example.netflixmgmt.models.IssueStatus;
import com.example.netflixmgmt.repositories.IIssueRepository;
import com.example.netflixmgmt.repositories.IIssueStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IssueStatusService {

    @Autowired
    private IIssueStatusRepository issueStatusRepository;

    public IssueStatus createIssueStatus(IssueStatus data){
        IssueStatus issueStatus=new IssueStatus();
        issueStatus.setName(data.getName());
        return issueStatusRepository.save(issueStatus);
    }

    public IssueStatus getById(Long id){
        return issueStatusRepository.findIssueStatusById(Long.valueOf(id));
    }

    public List<IssueStatus> getAll(){
        return issueStatusRepository.findAll();
    }

    public void deleteById(Long id){
        issueStatusRepository.deleteById(Long.valueOf(id));
    }

    public IssueStatus updateIssueStatus(IssueStatus data,Long id){
        IssueStatus issueStatus=issueStatusRepository.findIssueStatusById(Long.valueOf(id));
        if (data.getName()!=null) issueStatus.setName(data.getName());
        return issueStatusRepository.save(issueStatus);
    }
}
