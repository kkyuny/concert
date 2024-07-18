package com.hhdplus.concert.business.domain;

import com.hhdplus.concert.infrasturcture.entity.ConcertReserve;
import com.hhdplus.concert.infrasturcture.entity.User;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDomain {
    private Long concertId;
    private Long concertScheduleId;
    private Long userId;
    private LocalDate concertDate;
    private String status;
    private LocalDateTime validTime;
    private LocalDateTime regiDate;
    private Long seatNo;
    private Long price;
    private List<LocalDate> availableDates;
    private List<Long> availableSeats;

    public static ReservationDomain toDomain(ConcertReserve entity) {
        return ReservationDomain.builder()
                .concertId(entity.getConcertId())
                .concertScheduleId(entity.getConcertScheduleId())
                .seatNo(entity.getSeatNo())
                .build();
    }

    public static ConcertReserve toEntity(ReservationDomain domain) {
        return ConcertReserve.builder()
                .concertId(domain.getConcertId())
                .concertScheduleId(domain.getConcertScheduleId())
                .seatNo(domain.getSeatNo())
                .build();
    }
}
