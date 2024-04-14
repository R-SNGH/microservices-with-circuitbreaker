package com.example.citizenservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="citizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;
    /* coz we are using a separate DB as a design pattern
    *  To help us ID a citizen's registered vaccination center
    * */
    @Column
    int vaccinationCenterID;

}
