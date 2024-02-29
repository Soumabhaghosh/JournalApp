package com.marao.maraoSpring.controller;


import com.marao.maraoSpring.entity.entityClass;
import com.marao.maraoSpring.service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/abc")
public class journalEntryController {


    @Autowired
    private services journal_service;



    @GetMapping
    public  ArrayList<entityClass> getAll(){

        return journal_service.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody entityClass myEntry){

        return journal_service.saveEntry(myEntry);

        
    }

    @GetMapping("id/{myId}")
    public  entityClass getElementByid(@PathVariable String myId){

        return journal_service.findById(myId).orElse(null);

    }

    @DeleteMapping("id/{myId}")
    public  boolean deleteElementByid(@PathVariable String myId){

        return journal_service.deleteById(myId);

    }

    @PutMapping("id/{myId}")
    public  boolean updateByid(@PathVariable Long myId,@RequestBody entityClass myEntry){


        return true;

    }
}
