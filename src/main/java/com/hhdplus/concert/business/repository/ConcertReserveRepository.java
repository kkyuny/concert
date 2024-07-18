package com.hhdplus.concert.business.repository;

import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.infrasturcture.entity.ConcertReserve;

import java.time.LocalDate;
import java.util.List;

public interface ConcertReserveRepository {
    List<LocalDate> findAvailableDatesByConcertId(Long concertId);

    List<Long> findAvailableSeatByConcertIdAndDate(Long concertId, LocalDate date);

    void save(ReservationDomain domain);

    ReservationDomain getUserReserveStatus(Long concertId, Long concertScheduleId, Long seatNo);
}
