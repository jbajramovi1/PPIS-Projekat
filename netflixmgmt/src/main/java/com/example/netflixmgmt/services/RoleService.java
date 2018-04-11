package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Role;
import com.example.netflixmgmt.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    public Role createRole(Role data){
        Role role=new Role();
        role.setTitle(data.getTitle());
        return roleRepository.save(role);
    }

    public Role getById(Long id){
        return roleRepository.findRoleById(Long.valueOf(id));
    }

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public void deleteById(Long id){
        roleRepository.deleteById(Long.valueOf(id));
    }

    public Role updateRole(Role data,Long id){
        Role role=roleRepository.findRoleById(Long.valueOf(id));
        if(data.getTitle()!=null) role.setTitle(data.getTitle());
        return roleRepository.save(role);
    }
}
