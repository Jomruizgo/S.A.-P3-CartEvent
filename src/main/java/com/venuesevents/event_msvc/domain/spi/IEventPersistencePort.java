package com.venuesevents.event_msvc.domain.spi;

import com.venuesevents.event_msvc.domain.model.Event;

import java.util.List;

public interface IEventPersistencePort {
    Event saveEvent(Event event);

    Event getEventById(String eventId);

    List<Event> getAllEvents();

    void deleteEvent(String eventId);
}
