package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Component;
import com.example.netflixmgmt.models.Issue;
import com.example.netflixmgmt.models.IssueStatus;
import com.example.netflixmgmt.models.IssueType;
import com.example.netflixmgmt.repositories.IComponentRepository;
import com.example.netflixmgmt.repositories.IIssueRepository;
import com.example.netflixmgmt.repositories.IIssueStatusRepository;
import com.example.netflixmgmt.repositories.IIssueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IssueService {

    @Autowired
    private IIssueRepository issueRepository;

    @Autowired
    private IIssueStatusRepository issueStatusRepository;

    @Autowired
    private IComponentRepository componentRepository;

    public Issue createIssue(Issue data){
        Issue issue=new Issue();
        issue.setName(data.getName());
        issue.setDate(new Date());
        issue.setDescription(data.getDescription());
        issue.setAccount(data.getAccount());
        issue.setComponent(data.getComponent());
        issue.setIssueStatus(issueStatusRepository.findIssueStatusById(Long.valueOf(3)));
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

    public Map<String, Integer> getIssueStatistics(){
        Map<String, Integer> results = new LinkedHashMap<>();

//
        results.put("AllIssues", issueRepository.findAll().size());

        for (Component component:
                componentRepository.findAll()) {
            results.put(component.getName(),
                    issueRepository.findIssueByComponent(component).size());

        }

        return results;

    }
}
