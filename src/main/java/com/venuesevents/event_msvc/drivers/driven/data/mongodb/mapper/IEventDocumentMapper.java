package com.venuesevents.event_msvc.drivers.driven.data.mongodb.mapper;

import com.venuesevents.event_msvc.domain.model.Event;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.EventDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEventDocumentMapper {

    Event toModel(EventDocument eventDocument);
    EventDocument toDocument(Event event);


    List<Event> toModelList(List<EventDocument> eventDocuments);
    List<EventDocument> toDocumentList(List<Event> events);
}
