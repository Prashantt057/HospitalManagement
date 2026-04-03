package com.cg.hospitalmanagementsystem.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponse {

    private Integer ssn;
    private String name;
    private String address;
    private String phone;
    private Integer insuranceId;

    private Integer primaryCarePhysicianId;
    private String primaryCarePhysicianName;
}
