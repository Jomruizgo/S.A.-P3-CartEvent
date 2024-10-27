package com.venuesevents.event_msvc.drivers.driving.http.mapper;

import com.venuesevents.event_msvc.domain.model.Ticket;
import com.venuesevents.event_msvc.drivers.driving.http.dto.request.TicketRequestDto;
import com.venuesevents.event_msvc.drivers.driving.http.dto.response.TicketResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITicketDtoMapper {

    Ticket toModel(TicketRequestDto ticketRequestDto);
    @Mapping(target = "ticketId",source = "id")
    TicketResponseDto toResponseDto(Ticket ticket);
    List<TicketResponseDto> toResponseDtoList(List<Ticket> tickets);
}
