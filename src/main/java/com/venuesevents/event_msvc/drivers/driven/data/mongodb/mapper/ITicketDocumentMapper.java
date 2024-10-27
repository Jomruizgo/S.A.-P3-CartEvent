package com.venuesevents.event_msvc.drivers.driven.data.mongodb.mapper;

import com.venuesevents.event_msvc.domain.model.Ticket;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.TicketDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITicketDocumentMapper {

    Ticket toModel(TicketDocument ticketDocument);
    TicketDocument toDocument(Ticket ticket);

    List<Ticket> toModelList(List<TicketDocument> ticketDocuments);
    List<TicketDocument> toDocumentList(List<Ticket> tickets);
}
