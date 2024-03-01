package com.marao.maraoSpring.service;

import com.marao.maraoSpring.entity.entityClass;
import com.marao.maraoSpring.repository.repos;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class services   {

    @Autowired
    private repos repo;

    public boolean saveEntry(entityClass myData){

        repo.save(myData);

        return true;

    }
    public boolean isAvl(ObjectId Id){
       return repo.existsById(Id);
    }

    public Optional<entityClass> findById(ObjectId Id){
       return repo.findById(Id);
    }

    public ArrayList<entityClass> getAll(){



        return new ArrayList<entityClass>(repo.findAll());
    }

    public boolean deleteById(ObjectId Id){
        repo.deleteById(Id);

        return true;
    }

}
