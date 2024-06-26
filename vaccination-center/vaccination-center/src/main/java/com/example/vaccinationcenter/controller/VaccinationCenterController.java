package com.example.vaccinationcenter.controller;

import com.example.vaccinationcenter.entities.VaccinationCenter;
import com.example.vaccinationcenter.model.Citizen;
import com.example.vaccinationcenter.model.RequiredResponse;
import com.example.vaccinationcenter.repositories.VaccinationCenterRepository;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter newVaccinationCenter){
        VaccinationCenter center = repository.save(newVaccinationCenter);
        return new ResponseEntity<VaccinationCenter>(center, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
//    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    //when using Resiliance4J we can use Retry, RateLimiting + a circuitBreaker; requies specific config details in application.yml: 
    //@CircuitBreaker(name="supplyaname", fallbackMethod = "handleCitizenDownTime")
    //@Retry(name="supplyretryname", fallbackMethod = "handleCitizenDownTime")
    //@RateLimiter(name="supplyratelimitername", fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id){
        RequiredResponse requiredResponse =  new RequiredResponse();
        //1st fetching vaccination center details
        VaccinationCenter center  = repository.findById(id).get();
        requiredResponse.setCenter(center);

        // then fetch all citizens registered with this vaccination center
        // by connecting to CitizenDB
        // RestTemplate is used to connect from one service to another service
        // connecting to CitizenController getCitizensByVaccinationCenterId logic
        //List<Citizen> listOfCitizens = restTemplate.getForObject("http://localhost:8081/citizen/all/"+id, List.class);
        //asking eureka server to locate CITIZEN-SERVICE
        //add a loadbalanced RestTemplate bean . Its not available with auto configutations in SB 
        List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/all/"+id, List.class);
        requiredResponse.setCitizens(listOfCitizens);
        return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
    }

//    public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id){
//        RequiredResponse requiredResponse =  new RequiredResponse();
//        VaccinationCenter center  = repository.findById(id).get();
//        requiredResponse.setCenter(center);
//        return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
//    }
}
