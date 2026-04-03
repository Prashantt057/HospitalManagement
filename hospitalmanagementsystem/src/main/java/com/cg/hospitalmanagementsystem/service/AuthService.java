package com.cg.hospitalmanagementsystem.service;

import com.cg.hospitalmanagementsystem.dto.request.StaffLoginRequest;
import com.cg.hospitalmanagementsystem.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(StaffLoginRequest staffLoginRequest);
}
