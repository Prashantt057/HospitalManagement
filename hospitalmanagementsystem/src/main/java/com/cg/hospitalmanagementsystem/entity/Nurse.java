package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nurse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nurse {

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Position")
    private String position;

    @Column(name = "Registered")
    private Boolean registered;

    @Column(name = "SSN")
    private Integer ssn;



}



