package com.venuesevents.event_msvc.configuration;


import com.venuesevents.event_msvc.domain.api.IEventServicePort;
import com.venuesevents.event_msvc.domain.api.ITicketServicePort;
import com.venuesevents.event_msvc.domain.api.usecase.EventUseCase;
import com.venuesevents.event_msvc.domain.api.usecase.TicketUseCase;
import com.venuesevents.event_msvc.domain.spi.IEventPersistencePort;
import com.venuesevents.event_msvc.domain.spi.ITicketPersistencePort;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.adapter.EventAdapter;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.adapter.TicketAdapter;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.mapper.IEventDocumentMapper;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.mapper.ITicketDocumentMapper;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository.IEventRepository;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository.ITicketRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    private final IEventRepository eventRepository;
    private final IEventDocumentMapper eventDocumentMapper;
    private final ITicketRepository ticketRepository;
    private final ITicketDocumentMapper ticketDocumentMapper;

    public BeanConfiguration(IEventRepository eventRepository, IEventDocumentMapper eventDocumentMapper, ITicketRepository ticketRepository, ITicketDocumentMapper ticketDocumentMapper) {
        this.eventRepository = eventRepository;
        this.eventDocumentMapper = eventDocumentMapper;
        this.ticketRepository = ticketRepository;
        this.ticketDocumentMapper = ticketDocumentMapper;
    }

    @Bean
    public IEventServicePort eventServicePort(IEventPersistencePort eventPersistencePort) {
        return new EventUseCase(eventPersistencePort);
    }

    @Bean
    public ITicketServicePort ticketServicePort(ITicketPersistencePort ticketPersistencePort, IEventServicePort eventServicePort) {
        return new TicketUseCase(ticketPersistencePort, eventServicePort);
    }

    @Bean
    public IEventPersistencePort eventPersistencePort() {
        return new EventAdapter(eventRepository, eventDocumentMapper);
    }

    @Bean
    public ITicketPersistencePort ticketPersistencePort() {
        return new TicketAdapter(ticketRepository, ticketDocumentMapper);
    }

}
