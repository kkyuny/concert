package com.hhdplus.concert.application.dto;

import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.domain.UserDomain;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationFacadeDto {
    private Long concertId;
    private Long concertScheduleId;
    private Long userId;
    private String status;
    private LocalDateTime validTime;
    private LocalDateTime regiDate;
    private Long seatNo;
    private Long price;
    private List<LocalDate> availableDates;
    private List<Long> availableSeats;

    public static ReservationDomain toDomain(ReservationFacadeDto dto) {
        return ReservationDomain.builder()
                .concertId(dto.getConcertId())
                .concertScheduleId(dto.getConcertScheduleId())
                .userId(dto.getUserId())
                .status(dto.getStatus())
                .seatNo(dto.getSeatNo())
                .build();
    }

    public static ReservationFacadeDto toFacadeDto(ReservationDomain domain) {
        return ReservationFacadeDto.builder()
                .concertId(domain.getConcertId())
                .concertScheduleId(domain.getConcertScheduleId())
                .userId(domain.getUserId())
                .status(domain.getStatus())
                .seatNo(domain.getSeatNo())
                .availableDates(domain.getAvailableDates())
                .availableSeats(domain.getAvailableSeats())
                .build();
    }

    public static UserDomain toUserDomain(ReservationFacadeDto dto) {
        return UserDomain.builder()
                .userId(dto.getUserId())
                .amount(dto.getPrice())
                .build();
    }

}
