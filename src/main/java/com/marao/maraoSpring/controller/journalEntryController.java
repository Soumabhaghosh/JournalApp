package com.marao.maraoSpring.controller;


import com.marao.maraoSpring.entity.entityClass;
import com.marao.maraoSpring.service.services;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/abc")
public class journalEntryController {


    @Autowired
    private services journal_service;



    @GetMapping
    public  ArrayList<entityClass> getAll(){

        ArrayList<entityClass> all = journal_service.getAll();



        return all;
    }

    @PostMapping
    public boolean createEntry(@RequestBody entityClass myEntry){

        myEntry.setDate(LocalDateTime.now());
        return journal_service.saveEntry(myEntry);

        
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<?> getElementByid(@PathVariable ObjectId myId){

        Optional<entityClass> byId = journal_service.findById(myId);
        if(byId.isPresent()){
            return new ResponseEntity<>(byId.get(), HttpStatus.OK);
        }
        return new ResponseEntity<> (HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("id/{myId}")
    public  ResponseEntity<?> deleteElementByid(@PathVariable ObjectId myId){

        if(!journal_service.isAvl(myId)){
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(journal_service.deleteById(myId),HttpStatus.OK);

    }

    @PutMapping("id/{myId}")
    public  ResponseEntity<?> updateByid(@PathVariable ObjectId myId,@RequestBody entityClass myEntry){

        Optional<entityClass> postById = journal_service.findById(myId);

        if(postById.isPresent()){
            postById.get().setContent(myEntry.getContent());
            postById.get().setTitle(myEntry.getTitle());
            journal_service.saveEntry(postById.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
