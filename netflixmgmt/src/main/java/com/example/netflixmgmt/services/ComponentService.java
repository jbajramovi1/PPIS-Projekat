package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.Component;
import com.example.netflixmgmt.repositories.IComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ComponentService {

    @Autowired
    private IComponentRepository componentRepository;

    public Component createComponent(Component data){
        Component component=new Component();
        component.setName(data.getName());
        component.setDescription(data.getDescription());
        component.setContract(data.getContract());
        component.setAvailabilityType(data.getAvailabilityType());
        return componentRepository.save(component);
    }

    public Component getById(Long id){
        return componentRepository.findComponentById(Long.valueOf(id));
    }

    public List<Component> getAll(){
        return componentRepository.findAll();
    }

    public void deleteById(Long id){
        componentRepository.deleteById(Long.valueOf(id));
    }

    public Component updateComponent(Component data,Long id){
        Component component=componentRepository.findComponentById(Long.valueOf(id));
        if (data.getName()!=null) component.setName(data.getName());
        if (data.getDescription()!=null) component.setDescription(data.getDescription());
        if (data.getContract()!=null) component.setContract(data.getContract());
        if (data.getAvailabilityType()!=null) component.setAvailabilityType(data.getAvailabilityType());
        return componentRepository.save(component);
    }
}
