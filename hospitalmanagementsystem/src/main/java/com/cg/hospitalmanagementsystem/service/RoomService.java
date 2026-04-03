package com.cg.hospitalmanagementsystem.service;

import com.cg.hospitalmanagementsystem.dto.response.RoomResponse;

public interface RoomService {
    RoomResponse getRoomById(Integer roomNumber);
}
