package com.example.netflixmgmt.services;


import com.example.netflixmgmt.models.Account;
import com.example.netflixmgmt.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        Account userAccount = accountRepository.findAccountByUsername(s);
        if(userAccount == null) {
            throw new UsernameNotFoundException("User not found");
        }
//        return new User(userAccount.getUsername(), userAccount.getPassword(), getGrantedAuthorities(userAccount));
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return User.withUsername(userAccount.getUsername())
                .password(encoder.encode(userAccount.getPassword()))
                .authorities(getGrantedAuthorities(userAccount))
                .build();
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Account account) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole().getTitle()));
        return authorities;
    }
}