package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long id);
    Account findAccountByEmail(String email);
}
