package com.venuesevents.event_msvc.drivers.driven.data.mongodb.adapter;

import com.venuesevents.event_msvc.domain.model.Ticket;
import com.venuesevents.event_msvc.domain.spi.ITicketPersistencePort;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.TicketDocument;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.mapper.ITicketDocumentMapper;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository.ITicketRepository;

import java.util.List;
import java.util.Optional;

public class TicketAdapter implements ITicketPersistencePort {

    private final ITicketRepository ticketRepository;
    private final ITicketDocumentMapper ticketDocumentMapper;

    public TicketAdapter(ITicketRepository ticketRepository, ITicketDocumentMapper ticketDocumentMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketDocumentMapper = ticketDocumentMapper;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        TicketDocument ticketDocument = ticketDocumentMapper.toDocument(ticket);
        TicketDocument savedTicket = ticketRepository.save(ticketDocument);
        return ticketDocumentMapper.toModel(savedTicket);
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        Optional<TicketDocument> ticketDocument = ticketRepository.findById(ticketId);
        return ticketDocument.map(ticketDocumentMapper::toModel).orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<TicketDocument> ticketDocuments = ticketRepository.findAll();
        return ticketDocumentMapper.toModelList(ticketDocuments);
    }

    @Override
    public List<Ticket> findTicketListByIds(List<String> ticketIds) {
        List<TicketDocument> ticketDocuments = ticketRepository.findByIdIn(ticketIds);
        return ticketDocumentMapper.toModelList(ticketDocuments);
    }

    @Override
    public void deleteTicket(String ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
