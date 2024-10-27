package com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository;

import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.EventDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEventRepository extends MongoRepository<EventDocument, String> {
}
