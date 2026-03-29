package com.cg.hospitalmanagementsystem.entity;

import com.cg.hospitalmanagementsystem.entity.id.UndergoesId;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(UndergoesId.class)
@Table(name = "undergoes")
public class Undergoes {

    @Id
    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @Id
    @ManyToOne
    @JoinColumn(name = "procedures")
    private Procedure procedure;

    @Id
    @ManyToOne
    @JoinColumn(name = "stay")
    private Stay stay;

    private LocalDateTime dateUndergoes;

    @ManyToOne
    @JoinColumn(name = "physician")
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "assistingNurse")
    private Nurse nurse;
}