package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Issue;
import com.example.netflixmgmt.models.IssueStatus;
import com.example.netflixmgmt.models.IssueType;
import com.example.netflixmgmt.repositories.IIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IssueService {

    @Autowired
    private IIssueRepository issueRepository;

    public Issue createIssue(Issue data){
        Issue issue=new Issue();
        issue.setName(data.getName());
        issue.setDate(data.getDate());
        issue.setDescription(data.getDescription());
        issue.setAccount(data.getAccount());
        issue.setComponent(data.getComponent());
        issue.setIssueStatus(data.getIssueStatus());
        issue.setIssueType(data.getIssueType());
        return issueRepository.save(issue);
    }

    public Issue getById(Long id){
        return issueRepository.findIssueById(Long.valueOf(id));
    }

    public List<Issue> getByIssueType(IssueType issueType){
        return issueRepository.findIssueByIssueType(issueType);
    }

    public List<Issue> getByIssueStatus(IssueStatus issueStatus){
        return issueRepository.findIssueByIssueStatus(issueStatus);
    }

    public List<Issue> getAll(){
        return issueRepository.findAll();
    }

    public void deleteById(Long id){
        issueRepository.deleteById(Long.valueOf(id));
    }

    public Issue updateIssue(Issue data,Long id) {
        Issue issue = issueRepository.findIssueById(Long.valueOf(id));
        if (data.getName() != null) issue.setName(data.getName());
        if (data.getDate() != null) issue.setDate(data.getDate());
        if (data.getAccount() != null) issue.setAccount(data.getAccount());
        if (data.getComponent() != null) issue.setComponent(data.getComponent());
        if (data.getIssueStatus() != null) issue.setIssueStatus(data.getIssueStatus());
        if (data.getIssueType() != null) issue.setIssueType(data.getIssueType());
        return issueRepository.save(issue);
    }
}
