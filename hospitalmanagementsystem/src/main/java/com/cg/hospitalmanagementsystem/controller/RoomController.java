package com.cg.hospitalmanagementsystem.controller;

import com.cg.hospitalmanagementsystem.dto.response.RoomResponse;
import com.cg.hospitalmanagementsystem.service.imp.RoomServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    private final RoomServiceImp roomServiceImp;

    public RoomController(RoomServiceImp roomServiceImp) {
        this.roomServiceImp = roomServiceImp;
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable Integer id) {

        RoomResponse roomResponse = roomServiceImp.getRoomById(id);

        return ResponseEntity.ok(roomResponse);
    }

    @GetMapping("/availableRoom")
    public ResponseEntity<List<RoomResponse>>  getAvailableRooms(){
        List<RoomResponse> rooms = roomServiceImp.getAvailableRooms();
        return ResponseEntity.ok(rooms);

    }
}
