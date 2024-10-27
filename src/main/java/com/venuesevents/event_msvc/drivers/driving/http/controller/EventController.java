package com.venuesevents.event_msvc.drivers.driving.http.controller;

import com.venuesevents.event_msvc.domain.api.IEventServicePort;
import com.venuesevents.event_msvc.drivers.driving.http.dto.request.EventRequestDto;
import com.venuesevents.event_msvc.drivers.driving.http.dto.response.EventResponseDto;
import com.venuesevents.event_msvc.drivers.driving.http.mapper.IEventDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final IEventServicePort eventServicePort;
    private final IEventDtoMapper eventDtoMapper;

    public EventController(IEventServicePort eventServicePort, IEventDtoMapper eventDtoMapper) {
        this.eventServicePort = eventServicePort;
        this.eventDtoMapper = eventDtoMapper;
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto) {
        var event = eventDtoMapper.toModel(eventRequestDto);
        var createdEvent = eventServicePort.createEvent(event);
        var response = eventDtoMapper.toResponseDto(createdEvent);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable String eventId, @RequestBody EventRequestDto eventRequestDto) {
        var event = eventDtoMapper.toModel(eventRequestDto);
        var updatedEvent = eventServicePort.updateEvent(eventId, event);
        var response = eventDtoMapper.toResponseDto(updatedEvent);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable String eventId) {
        var event = eventServicePort.getEventById(eventId);
        var response = eventDtoMapper.toResponseDto(event);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        var events = eventServicePort.getAllEvents();
        var responseList = eventDtoMapper.toResponseDtoList(events);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
