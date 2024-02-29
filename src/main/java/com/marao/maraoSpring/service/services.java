package com.marao.maraoSpring.service;

import com.marao.maraoSpring.entity.entityClass;
import com.marao.maraoSpring.repository.repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class services   {

    @Autowired
    private repos repo;

    public boolean saveEntry(entityClass myData){

        repo.save(myData);

        return true;

    }

    public Optional<entityClass> findById(String Id){
       return repo.findById(Id);
    }

    public ArrayList<entityClass> getAll(){
       return  new ArrayList<>(repo.findAll());
    }

    public boolean deleteById(String Id){
        repo.deleteById(Id);

        return true;
    }

}
