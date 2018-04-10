package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.UserRole;
import com.example.netflixmgmt.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        com.example.netflixmgmt.models.User userAccount = userRepository.findUserByEmail(s);
        if(userAccount == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(userAccount.getEmail(), userAccount.getPassword(), getGrantedAuthorities(userAccount));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(com.example.netflixmgmt.models.User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getUserRoleList() != null) {
            for(UserRole userRole : user.getUserRoleList())
                authorities.add(new SimpleGrantedAuthority(userRole.getRole().getTitle()));
        }
        return authorities;
    }
}