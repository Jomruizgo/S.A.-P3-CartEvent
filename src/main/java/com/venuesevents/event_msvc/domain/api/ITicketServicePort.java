package com.venuesevents.event_msvc.domain.api;

import com.venuesevents.event_msvc.domain.model.Ticket;

import java.util.List;
import java.util.Map;

public interface ITicketServicePort {

    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(String ticketId, Ticket ticket);

    Ticket getTicketById(String ticketId);

    List<Ticket> getAllTickets();

    List<Ticket> findTicketListByIds(List<String> ticketIds);

    Map<String, Integer> verifyAndBlockTicketQuantities(Map<String, Integer> ticketQuantities);

    void deleteTicket(String ticketId);
}
