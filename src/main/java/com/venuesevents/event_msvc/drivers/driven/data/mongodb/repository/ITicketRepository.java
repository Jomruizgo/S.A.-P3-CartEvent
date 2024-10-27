package com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository;

import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.TicketDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITicketRepository extends MongoRepository<TicketDocument, String> {

    List<TicketDocument> findByIdIn(List<String> ticketIds);
}
