package com.hhdplus.concert.application.facade;

import com.hhdplus.concert.application.dto.ReservationFacadeDto;
import com.hhdplus.concert.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationFacade {

    @Autowired
    ReservationService reservationService;

    public ReservationFacadeDto getAvailableDates(ReservationFacadeDto dto) {
        return ReservationFacadeDto.toFacadeDto(reservationService.getAvailableDates(ReservationFacadeDto.toDomain(dto)));
    }

    public ReservationFacadeDto getAvailableSeats(ReservationFacadeDto dto) {
        return ReservationFacadeDto.toFacadeDto(reservationService.getAvailableSeats(ReservationFacadeDto.toDomain(dto)));
    }

    public ReservationFacadeDto reserveSeat(ReservationFacadeDto dto) {
        reservationService.reserveSeat(ReservationFacadeDto.toDomain(dto));
        return dto;
    }
}
