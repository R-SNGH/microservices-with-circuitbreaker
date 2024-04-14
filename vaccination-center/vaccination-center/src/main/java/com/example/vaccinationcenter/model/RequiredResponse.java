package com.example.vaccinationcenter.model;

import com.example.vaccinationcenter.entities.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {
    private VaccinationCenter center;
    private List<Citizen> citizens;
}
