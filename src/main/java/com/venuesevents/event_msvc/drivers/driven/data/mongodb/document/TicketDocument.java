package com.venuesevents.event_msvc.drivers.driven.data.mongodb.document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TicketDocument {

    @Id
    private String id;

    private String name;
    private String eventId;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String internalLocation;
    private BigDecimal price;
    private int availableQuantity;
    private int blockedQuantity;

}
