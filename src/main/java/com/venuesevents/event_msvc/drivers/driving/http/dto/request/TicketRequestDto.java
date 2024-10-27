package com.venuesevents.event_msvc.drivers.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TicketRequestDto {
    private String name;
    private String description;
    private String eventId;
    private String internalLocation;
    private BigDecimal price;
    private Integer availableQuantity;
    private Integer blockedQuantity;
}
