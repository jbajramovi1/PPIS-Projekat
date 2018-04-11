package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.IssueType;
import com.example.netflixmgmt.repositories.IIssueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IssueTypeService {

    @Autowired
    private IIssueTypeRepository issueTypeRepository;

    public IssueType createIssueType(IssueType data){
        IssueType issueType=new IssueType();
        issueType.setName(data.getName());
        issueType.setDescription(data.getDescription());
        return issueTypeRepository.save(issueType);
    }

    public IssueType getById(Long id){
        return issueTypeRepository.findIssueTypeById(Long.valueOf(id));
    }

    public List<IssueType> getAll(){
        return issueTypeRepository.findAll();
    }

    public void deleteById(Long id){
        issueTypeRepository.deleteById(Long.valueOf(id));
    }

    public IssueType updateIssueType(IssueType data,Long id){
        IssueType issueType=issueTypeRepository.findIssueTypeById(Long.valueOf(id));
        if (data.getName()!=null) issueType.setName(data.getName());
        if (data.getDescription()!=null) issueType.setDescription(data.getDescription());
        return issueTypeRepository.save(issueType);
    }
}
