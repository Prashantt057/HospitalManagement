package com.cg.hospitalmanagementsystem.mapper;

import com.cg.hospitalmanagementsystem.dto.response.PatientResponse;
import com.cg.hospitalmanagementsystem.entity.Patient;

public class PatientMapper {

    public static PatientResponse mapToDto(Patient patient) {

        Integer physicianId = null;
        String physicianName = null;

        if (patient.getPrimaryCarePhysician() != null) {
            physicianId = patient.getPrimaryCarePhysician().getEmployeeId();
            physicianName = patient.getPrimaryCarePhysician().getName();
        }

        return PatientResponse.builder()
                .ssn(patient.getSsn())
                .name(patient.getName())
                .address(patient.getAddress())
                .phone(patient.getPhone())
                .insuranceId(patient.getInsuranceId())
                .primaryCarePhysicianId(physicianId)
                .primaryCarePhysicianName(physicianName)
                .build();
    }
}
