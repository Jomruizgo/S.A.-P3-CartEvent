package com.venuesevents.event_msvc.drivers.driven.data.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "events")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EventDocument {
    @Id
    private String id;

    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String location;
}
