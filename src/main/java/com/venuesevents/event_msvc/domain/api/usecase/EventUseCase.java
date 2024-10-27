package com.venuesevents.event_msvc.domain.api.usecase;

import com.venuesevents.event_msvc.domain.api.IEventServicePort;
import com.venuesevents.event_msvc.domain.exception.ObjectNotFoundException;
import com.venuesevents.event_msvc.domain.model.Event;
import com.venuesevents.event_msvc.domain.spi.IEventPersistencePort;

import java.time.LocalDateTime;
import java.util.List;

public class EventUseCase implements IEventServicePort {

    private final IEventPersistencePort eventPersistencePort;

    public EventUseCase(IEventPersistencePort eventPersistencePort) {
        this.eventPersistencePort = eventPersistencePort;
    }

    @Override
    public Event createEvent(Event event) {
        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());
        return eventPersistencePort.saveEvent(event);
    }

    @Override
    public Event updateEvent(String eventId, Event event) {
        Event existingEvent = eventPersistencePort.getEventById(eventId);
        if (existingEvent != null) {
            event.setUpdatedAt(LocalDateTime.now());
            return eventPersistencePort.saveEvent(event);
        }
        throw new ObjectNotFoundException("Event not found");
    }

    @Override
    public Event getEventById(String eventId) {
        return eventPersistencePort.getEventById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventPersistencePort.getAllEvents();
    }

    @Override
    public void deleteEvent(String eventId) {
        eventPersistencePort.deleteEvent(eventId);
    }
}
