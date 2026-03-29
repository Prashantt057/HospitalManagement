package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stay")
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stayId;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "room")
    private Room room;

    private LocalDateTime stayStart;
    private LocalDateTime stayEnd;

    public Stay() {}

    public Integer getStayId() {
        return stayId;
    }

    public void setStayId(Integer stayId) {
        this.stayId = stayId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getStayStart() {
        return stayStart;
    }

    public void setStayStart(LocalDateTime stayStart) {
        this.stayStart = stayStart;
    }

    public LocalDateTime getStayEnd() {
        return stayEnd;
    }

    public void setStayEnd(LocalDateTime stayEnd) {
        this.stayEnd = stayEnd;
    }
}