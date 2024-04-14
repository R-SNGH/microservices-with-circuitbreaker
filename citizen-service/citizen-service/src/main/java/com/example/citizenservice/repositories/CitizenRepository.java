package com.example.citizenservice.repositories;

import com.example.citizenservice.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer>{

    List<Citizen> findByVaccinationCenterID(Integer id);
}
