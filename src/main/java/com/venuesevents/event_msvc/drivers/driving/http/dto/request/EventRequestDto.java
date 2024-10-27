package com.venuesevents.event_msvc.drivers.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EventRequestDto {
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
}
