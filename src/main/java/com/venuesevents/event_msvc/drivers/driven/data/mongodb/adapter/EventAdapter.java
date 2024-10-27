package com.venuesevents.event_msvc.drivers.driven.data.mongodb.adapter;

import com.venuesevents.event_msvc.domain.model.Event;
import com.venuesevents.event_msvc.domain.spi.IEventPersistencePort;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.EventDocument;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.mapper.IEventDocumentMapper;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository.IEventRepository;

import java.util.List;
import java.util.Optional;

public class EventAdapter implements IEventPersistencePort {

    private final IEventRepository eventRepository;
    private final IEventDocumentMapper eventDocumentMapper;

    public EventAdapter(IEventRepository eventRepository, IEventDocumentMapper eventDocumentMapper) {
        this.eventRepository = eventRepository;
        this.eventDocumentMapper = eventDocumentMapper;
    }


    @Override
    public Event saveEvent(Event event) {
        EventDocument eventDocument = eventDocumentMapper.toDocument(event);
        EventDocument savedEvent = eventRepository.save(eventDocument);
        return eventDocumentMapper.toModel(savedEvent);
    }

    @Override
    public Event getEventById(String eventId) {
        Optional<EventDocument> eventDocument = eventRepository.findById(eventId);
        return eventDocument.map(eventDocumentMapper::toModel).orElse(null);
    }

    @Override
    public List<Event> getAllEvents() {
        List<EventDocument> eventDocuments = eventRepository.findAll();
        return eventDocumentMapper.toModelList(eventDocuments);
    }

    @Override
    public void deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
    }
}
