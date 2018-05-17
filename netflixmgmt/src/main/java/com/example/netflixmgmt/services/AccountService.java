package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Account;
import com.example.netflixmgmt.models.Role;
import com.example.netflixmgmt.repositories.IAccountRepository;
import com.example.netflixmgmt.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public Account createAccount(Account data){
        // TODO fix unique constraint exception!a
        Account account=new Account();
        account.setUsername(data.getUsername());
        account.setPassword(data.getPassword());
        Role role = roleRepository.findRoleByTitle("ROLE_USER");

        if (role == null)
            role = roleRepository.save(new Role(null, "ROLE_USER", null));

        account.setRole(role);
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
        if (data.getUsername()!=null) account.setUsername(data.getUsername());
        if (data.getPassword()!=null) account.setPassword(data.getPassword());
        if (data.getRole()!=null) account.setRole(data.getRole());
        return accountRepository.save(account);
    }
}
