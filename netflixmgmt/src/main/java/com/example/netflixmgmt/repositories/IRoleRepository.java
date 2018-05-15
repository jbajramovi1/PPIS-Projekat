package com.example.netflixmgmt.repositories;

import com.example.netflixmgmt.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<Role,Long> {
    Role findRoleById(Long id);
    List<Role> findAll();
    Role findRoleByTitle(String title);
}
