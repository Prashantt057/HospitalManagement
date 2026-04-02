package com.cg.hospitalmanagementsystem.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class StaffLoginRequest {


    private String email;
    private String password;


}

