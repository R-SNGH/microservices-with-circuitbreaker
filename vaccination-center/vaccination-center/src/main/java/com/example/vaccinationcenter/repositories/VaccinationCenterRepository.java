package com.example.vaccinationcenter.repositories;

import com.example.vaccinationcenter.entities.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {
}
