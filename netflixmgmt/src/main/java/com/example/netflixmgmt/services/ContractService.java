package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Contract;
import com.example.netflixmgmt.repositories.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractService {

    @Autowired
    private IContractRepository contractRepository;

    public Contract createContract(Contract data){
        Contract contract=new Contract();
        contract.setName(data.getName());
        contract.setDescription(data.getDescription());
        contract.setClient(data.getClient());
        return contractRepository.save(contract);
    }

    public Contract getById(Long id){
        return contractRepository.findContractById(Long.valueOf(id));
    }

    public List<Contract> getAll(){
        return contractRepository.findAll();
    }

    public void deleteById(Long id){
        contractRepository.deleteById(Long.valueOf(id));
    }

    public Contract updateContract(Contract data,Long id){
        Contract contract=contractRepository.findContractById(Long.valueOf(id));
        if (data.getName()!=null) contract.setName(data.getName());
        if (data.getDescription()!=null) contract.setDescription(data.getDescription());
        if (data.getClient()!=null) contract.setClient(data.getClient());
        return contractRepository.save(contract);
    }
}
