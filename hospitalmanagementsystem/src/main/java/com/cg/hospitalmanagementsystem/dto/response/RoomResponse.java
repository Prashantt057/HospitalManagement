package com.cg.hospitalmanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponse {
    private Integer roomNumber;
    private String roomType;

    private Integer blockCode;
    private Integer blockFloor;

    private Boolean unavailable;
}
