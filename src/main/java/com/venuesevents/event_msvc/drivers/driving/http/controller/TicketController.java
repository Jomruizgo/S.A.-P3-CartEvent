package com.venuesevents.event_msvc.drivers.driving.http.controller;

import com.venuesevents.event_msvc.domain.api.ITicketServicePort;
import com.venuesevents.event_msvc.drivers.driving.http.dto.request.TicketRequestDto;
import com.venuesevents.event_msvc.drivers.driving.http.dto.response.TicketResponseDto;
import com.venuesevents.event_msvc.drivers.driving.http.mapper.ITicketDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event/ticket")
public class TicketController {

    private final ITicketServicePort ticketServicePort;
    private final ITicketDtoMapper ticketDtoMapper;

    public TicketController(ITicketServicePort ticketServicePort, ITicketDtoMapper ticketDtoMapper) {
        this.ticketServicePort = ticketServicePort;
        this.ticketDtoMapper = ticketDtoMapper;
    }

    @PostMapping
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketRequestDto ticketRequestDto) {
        var ticket = ticketDtoMapper.toModel(ticketRequestDto);
        var createdTicket = ticketServicePort.createTicket(ticket);
        var response = ticketDtoMapper.toResponseDto(createdTicket);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> updateTicket(@PathVariable String ticketId, @RequestBody TicketRequestDto ticketRequestDto) {
        var ticket = ticketDtoMapper.toModel(ticketRequestDto);
        var updatedTicket = ticketServicePort.updateTicket(ticketId, ticket);
        var response = ticketDtoMapper.toResponseDto(updatedTicket);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable String ticketId) {
        var ticket = ticketServicePort.getTicketById(ticketId);
        var response = ticketDtoMapper.toResponseDto(ticket);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDto>> getAllTickets() {
        var tickets = ticketServicePort.getAllTickets();
        var responseList = ticketDtoMapper.toResponseDtoList(tickets);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/batch")
    public ResponseEntity<List<TicketResponseDto>> getTicketsByIds(@RequestParam List<String> ticketIds) {

        List<TicketResponseDto> tickets = ticketDtoMapper.toResponseDtoList(
                ticketServicePort.findTicketListByIds(ticketIds)
        );

        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
