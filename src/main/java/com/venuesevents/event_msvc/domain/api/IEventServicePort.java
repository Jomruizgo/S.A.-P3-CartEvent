package com.venuesevents.event_msvc.domain.api;

import com.venuesevents.event_msvc.domain.model.Event;

import java.util.List;

public interface IEventServicePort {

    Event createEvent(Event event);

    Event updateEvent(String eventId, Event event);

    Event getEventById(String eventId);

    List<Event> getAllEvents();

    void deleteEvent(String eventId);
}
