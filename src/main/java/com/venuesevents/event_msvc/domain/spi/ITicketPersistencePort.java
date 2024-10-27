package com.venuesevents.event_msvc.domain.spi;

import com.venuesevents.event_msvc.domain.model.Ticket;

import java.util.List;

public interface ITicketPersistencePort {
    Ticket saveTicket(Ticket ticket);

    Ticket getTicketById(String ticketId);

    List<Ticket> getAllTickets();

    List<Ticket> findTicketListByIds(List<String> ticketIds);

    void deleteTicket(String ticketId);
}
