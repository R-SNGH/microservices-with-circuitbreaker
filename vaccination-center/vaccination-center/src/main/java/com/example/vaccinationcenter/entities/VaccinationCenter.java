package com.example.vaccinationcenter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vaccination-center")
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String vaccinationCenterName;
    private String vaccinationCenterAddress;
}
