package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Account;
import com.example.netflixmgmt.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    private IAccountRepository accountRepository;

    public Account createAccount(Account data){
        Account account=new Account();
        account.setEmail(data.getEmail());
        account.setPassword(data.getPassword());
        account.setRole(data.getRole());
        return accountRepository.save(account);
    }

    public Account getById(Long id){
        return accountRepository.findAccountById(Long.valueOf(id));
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public void deleteById(Long id){
        accountRepository.deleteById(Long.valueOf(id));
    }

    public Account updateOffer(Account data,Long id){
        Account account=accountRepository.findAccountById(Long.valueOf(id));
        if (data.getEmail()!=null) account.setEmail(data.getEmail());
        if (data.getPassword()!=null) account.setPassword(data.getPassword());
        if (data.getRole()!=null) account.setRole(data.getRole());
        return accountRepository.save(account);
    }
}
