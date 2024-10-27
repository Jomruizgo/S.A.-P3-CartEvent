package com.venuesevents.event_msvc.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {


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

    public Ticket() {}

    public Ticket(String id, String name, String eventId, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String internalLocation, BigDecimal price, int availableQuantity, int blockedQuantity) {
        this.id = id;
        this.name = name;
        this.eventId = eventId;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.internalLocation = internalLocation;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.blockedQuantity = blockedQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getInternalLocation() {
        return internalLocation;
    }

    public void setInternalLocation(String internalLocation) {
        this.internalLocation = internalLocation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getBlockedQuantity() {
        return blockedQuantity;
    }

    public void setBlockedQuantity(int blockedQuantity) {
        this.blockedQuantity = blockedQuantity;
    }
}
