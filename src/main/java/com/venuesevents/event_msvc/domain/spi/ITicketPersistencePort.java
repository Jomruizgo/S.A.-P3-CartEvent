package com.venuesevents.event_msvc.domain.spi;

import com.venuesevents.event_msvc.domain.model.Ticket;

import java.util.List;
import java.util.Map;

public interface ITicketPersistencePort {
    Ticket saveTicket(Ticket ticket);

    Ticket getTicketById(String ticketId);

    List<Ticket> getAllTickets();

    List<Ticket> findTicketListByIds(List<String> ticketIds);

    Map<String, Integer> verifyAndBlockTicketQuantities(Map<String, Integer> ticketQuantities);

    void deleteTicket(String ticketId);
}
