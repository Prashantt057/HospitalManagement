package com.cg.hospitalmanagementsystem.service;




import com.cg.hospitalmanagementsystem.entity.Appointment;

import java.util.List;


public interface DoctorService {


    List<PhysicianPatientResponse> allAssignedPatients(PhysicianRequest physicianRequest);


    List<Appointment> allAssignedAppointments(PhysicianRequest physicianRequest);


    List<Prescribes> allAssignedPrescriptions(PhysicianRequest physicianRequest);




}


