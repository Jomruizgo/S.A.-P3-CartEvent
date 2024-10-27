package com.venuesevents.event_msvc.domain.api.usecase;

import com.venuesevents.event_msvc.domain.api.IEventServicePort;
import com.venuesevents.event_msvc.domain.api.ITicketServicePort;
import com.venuesevents.event_msvc.domain.exception.ObjectNotFoundException;
import com.venuesevents.event_msvc.domain.model.Event;
import com.venuesevents.event_msvc.domain.model.Ticket;
import com.venuesevents.event_msvc.domain.spi.ITicketPersistencePort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TicketUseCase implements ITicketServicePort {

    private final ITicketPersistencePort ticketPersistencePort;
    private final IEventServicePort eventServicePort;

    public TicketUseCase(ITicketPersistencePort ticketPersistencePort, IEventServicePort eventServicePort) {
        this.ticketPersistencePort = ticketPersistencePort;
        this.eventServicePort = eventServicePort;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        // Validar que el evento exista
        Event event = eventServicePort.getEventById(ticket.getEventId());
        if (event == null) {
            throw new ObjectNotFoundException("Cannot create ticket. Event does not exist.");
        }
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());
        return ticketPersistencePort.saveTicket(ticket);
    }

    @Override
    public Ticket updateTicket(String ticketId, Ticket ticket) {
        Ticket existingTicket = ticketPersistencePort.getTicketById(ticketId);
        if (existingTicket != null) {
            ticket.setUpdatedAt(LocalDateTime.now());
            return ticketPersistencePort.saveTicket(ticket);
        }
        throw new ObjectNotFoundException("Ticket not found");
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        return ticketPersistencePort.getTicketById(ticketId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketPersistencePort.getAllTickets();
    }

    @Override
    public List<Ticket> findTicketListByIds(List<String> ticketIds) {
        return ticketPersistencePort.findTicketListByIds(ticketIds);
    }

    @Override
    public Map<String, Integer> verifyAndBlockTicketQuantities(Map<String, Integer> ticketQuantities) {
        return ticketPersistencePort.verifyAndBlockTicketQuantities(ticketQuantities);
    }


    @Override
    public void deleteTicket(String ticketId) {
        ticketPersistencePort.deleteTicket(ticketId);
    }
}
