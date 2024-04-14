package com.example.citizenservice.controller;

import com.example.citizenservice.entities.Citizen;
import com.example.citizenservice.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepository repository;

    //to test this controller
    @RequestMapping("/test")
    public ResponseEntity<String> test(){

        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Citizen>> getCitizensByVaccinationCenterId(@PathVariable Integer id){
        List<Citizen> citizens = repository.findByVaccinationCenterID(id);
        return new ResponseEntity<List<Citizen>>(citizens, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Citizen>> getAllCitizens(){
        List<Citizen> citizens =repository.findAll();
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
        Citizen citizenSaved = repository.save(newCitizen);
        return new ResponseEntity<>(citizenSaved, HttpStatus.CREATED);
    }

}
