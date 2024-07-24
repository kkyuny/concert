package com.hhdplus.concert.interfaces.presentation.controller;

import com.hhdplus.concert.application.facade.ReservationFacade;
import com.hhdplus.concert.interfaces.presentation.common.exception.InvalidReqBodyException;
import com.hhdplus.concert.interfaces.presentation.dto.request.ReservationRequestDto;
import com.hhdplus.concert.interfaces.presentation.dto.response.ReservationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reservation")
@Tag(name = "콘서트 예약", description = "예약가능 목록 조회 및 좌석 예약 API")
public class ReservationController {

    @Autowired
    ReservationFacade reservationFacade;

    @GetMapping("/dates")
    @Operation(summary = "예약가능 날짜 조회", description = "예약가능 날짜 조회 API")
    public ReservationResponseDto getAvailableDates(@RequestBody ReservationRequestDto dto) throws InvalidReqBodyException {
        validateRequest(dto, false);

        return ReservationResponseDto.toResponse(reservationFacade.getAvailableDates(ReservationRequestDto.toFacadeDto(dto)));
    }

    @GetMapping("/seats")
    @Operation(summary = "예약가능 좌석 조회", description = "예약가능 좌석 조회 API")
    public ReservationResponseDto getAvailableSeats(@RequestBody ReservationRequestDto dto) throws InvalidReqBodyException {
        validateRequest(dto, false);

        return ReservationResponseDto.toResponse(reservationFacade.getAvailableSeats(ReservationRequestDto.toFacadeDto(dto)));
    }

    @PostMapping("/reserve")
    @Operation(summary = "좌석 예약", description = "좌석 예약 API")
    public ReservationResponseDto reserveSeat(@RequestBody ReservationRequestDto dto) throws InvalidReqBodyException {
        validateRequest(dto, true);

        return ReservationResponseDto.toResponse(reservationFacade.reserveSeat(ReservationRequestDto.toFacadeDto(dto)));
    }

    private void validateRequest(ReservationRequestDto dto, boolean checkSeatNo) throws InvalidReqBodyException {
        if (dto.getConcertDate() == null) {
            throw new InvalidReqBodyException("ConcertDate is invalid.");
        }
        if (dto.getConcertId() == null) {
            throw new InvalidReqBodyException("ConcertId is invalid.");
        }
        if (checkSeatNo && dto.getSeatNo() == null) {
            throw new InvalidReqBodyException("SeatNo is invalid.");
        }
    }
}
