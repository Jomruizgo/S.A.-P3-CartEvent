package com.venuesevents.event_msvc.configuration;

import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.EventDocument;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.document.TicketDocument;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository.IEventRepository;
import com.venuesevents.event_msvc.drivers.driven.data.mongodb.repository.ITicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

@Configuration
public class DataInitialization {

    @Bean
    CommandLineRunner initData(IEventRepository eventRepository, ITicketRepository ticketRepository) {
        return args -> {
            // Crear eventos
            EventDocument event1 = new EventDocument();
            event1.setId(UUID.randomUUID().toString());
            event1.setName("Concert XYZ");
            event1.setDescription("A live music concert featuring popular artists.");
            event1.setStartDate(LocalDateTime.of(2024, Month.NOVEMBER, 1, 19, 0));
            event1.setEndDate(LocalDateTime.of(2024, Month.NOVEMBER, 1, 23, 0));
            event1.setCreatedAt(LocalDateTime.now());
            event1.setUpdatedAt(LocalDateTime.now());
            event1.setLocation("Stadium ABC");

            EventDocument event2 = new EventDocument();
            event2.setId(UUID.randomUUID().toString());
            event2.setName("Tech Conference 2024");
            event2.setDescription("Annual technology conference with speakers from around the world.");
            event2.setStartDate(LocalDateTime.of(2024, Month.DECEMBER, 15, 9, 0));
            event2.setEndDate(LocalDateTime.of(2024, Month.DECEMBER, 17, 17, 0));
            event2.setCreatedAt(LocalDateTime.now().minusMonths(1));
            event2.setUpdatedAt(LocalDateTime.now().minusMonths(1));
            event2.setLocation("Convention Center DEF");

            EventDocument event3 = new EventDocument();
            event3.setId(UUID.randomUUID().toString());
            event3.setName("Food Festival 2024");
            event3.setDescription("A food festival showcasing the best local and international cuisines.");
            event3.setStartDate(LocalDateTime.of(2024, Month.NOVEMBER, 25, 10, 0));
            event3.setEndDate(LocalDateTime.of(2024, Month.NOVEMBER, 26, 22, 0));
            event3.setCreatedAt(LocalDateTime.now());
            event3.setUpdatedAt(LocalDateTime.now());
            event3.setLocation("Park GHI");

            eventRepository.save(event1);
            eventRepository.save(event2);
            eventRepository.save(event3);

            // Crear tickets relacionados con los eventos usando el id del evento
            TicketDocument ticket1 = new TicketDocument();
            ticket1.setId(UUID.randomUUID().toString());
            ticket1.setName("VIP Ticket");
            ticket1.setEventId(event1.getId());
            ticket1.setDescription("VIP access to Concert XYZ");
            ticket1.setCreatedAt(LocalDateTime.now());
            ticket1.setUpdatedAt(LocalDateTime.now());
            ticket1.setInternalLocation("Section A");
            ticket1.setPrice(new BigDecimal("150.00"));
            ticket1.setAvailableQuantity(50);
            ticket1.setBlockedQuantity(0);

            TicketDocument ticket2 = new TicketDocument();
            ticket2.setId(UUID.randomUUID().toString());
            ticket2.setName("Standard Ticket");
            ticket2.setEventId(event1.getId());
            ticket2.setDescription("General admission to Concert XYZ");
            ticket2.setCreatedAt(LocalDateTime.now());
            ticket2.setUpdatedAt(LocalDateTime.now());
            ticket2.setInternalLocation("Section B");
            ticket2.setPrice(new BigDecimal("75.00"));
            ticket2.setAvailableQuantity(100);
            ticket2.setBlockedQuantity(0);

            TicketDocument ticket3 = new TicketDocument();
            ticket3.setId(UUID.randomUUID().toString());
            ticket3.setName("Conference Access - Full");
            ticket3.setEventId(event2.getId());
            ticket3.setDescription("Full access to Tech Conference 2024");
            ticket3.setCreatedAt(LocalDateTime.now());
            ticket3.setUpdatedAt(LocalDateTime.now());
            ticket3.setInternalLocation("Main Hall");
            ticket3.setPrice(new BigDecimal("200.00"));
            ticket3.setAvailableQuantity(200);
            ticket3.setBlockedQuantity(0);

            TicketDocument ticket4 = new TicketDocument();
            ticket4.setId(UUID.randomUUID().toString());
            ticket4.setName("Festival Entry - Day 1");
            ticket4.setEventId(event3.getId());
            ticket4.setDescription("Access to day 1 of Food Festival 2024");
            ticket4.setCreatedAt(LocalDateTime.now());
            ticket4.setUpdatedAt(LocalDateTime.now());
            ticket4.setInternalLocation("East Entrance");
            ticket4.setPrice(new BigDecimal("50.00"));
            ticket4.setAvailableQuantity(150);
            ticket4.setBlockedQuantity(0);

            TicketDocument ticket5 = new TicketDocument();
            ticket5.setId(UUID.randomUUID().toString());
            ticket5.setName("Festival Entry - Both Days");
            ticket5.setEventId(event3.getId());
            ticket5.setDescription("Access to both days of Food Festival 2024");
            ticket5.setCreatedAt(LocalDateTime.now());
            ticket5.setUpdatedAt(LocalDateTime.now());
            ticket5.setInternalLocation("West Entrance");
            ticket5.setPrice(new BigDecimal("80.00"));
            ticket5.setAvailableQuantity(100);
            ticket5.setBlockedQuantity(0);

            ticketRepository.save(ticket1);
            ticketRepository.save(ticket2);
            ticketRepository.save(ticket3);
            ticketRepository.save(ticket4);
            ticketRepository.save(ticket5);
        };
    }
}