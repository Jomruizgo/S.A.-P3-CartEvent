package com.venuesevents.event_msvc.drivers.driving.http.mapper;

import com.venuesevents.event_msvc.domain.model.Event;
import com.venuesevents.event_msvc.drivers.driving.http.dto.request.EventRequestDto;
import com.venuesevents.event_msvc.drivers.driving.http.dto.response.EventResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEventDtoMapper {

    Event toModel(EventRequestDto eventRequestDto);
    EventResponseDto toResponseDto(Event event);

    List<EventResponseDto> toResponseDtoList(List<Event> events);
}
