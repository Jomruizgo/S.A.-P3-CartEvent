package com.venuesevents.event_msvc.drivers.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EventResponseDto {
    private String eventId;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
}
