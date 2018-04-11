package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findAccountById(Long id);
    Account findAccountByEmail(String email);
    List<Account> findAll();

}
