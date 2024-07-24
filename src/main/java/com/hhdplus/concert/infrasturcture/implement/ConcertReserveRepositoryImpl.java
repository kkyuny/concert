package com.hhdplus.concert.infrasturcture.implement;

import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.repository.ConcertReserveRepository;
import com.hhdplus.concert.infrasturcture.entity.ConcertReserve;
import com.hhdplus.concert.infrasturcture.repository.ConcertReserveJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConcertReserveRepositoryImpl implements ConcertReserveRepository {
    @Autowired
    private ConcertReserveJpaRepository jpaRepository;

    @Override
    public List<LocalDate> findAvailableDatesByConcertId(Long concertId) {
        return jpaRepository.findAvailableDatesByConcertId(concertId);
    }

    @Override
    public List<Long> findAvailableSeatByConcertIdAndDate(Long concertId, LocalDate date) {
        return jpaRepository.findAvailableSeatByConcertIdAndDate(concertId, date);
    }

    @Override
    public void save(ReservationDomain domain) {
        ReservationDomain.toDomain(jpaRepository.save(ConcertReserve.toEntity(domain)));
    }

    @Override
    public ReservationDomain getUserReserveStatus(Long concertId, Long concertScheduleId, Long seatNo) {
        return jpaRepository.findUserConcertReserve(concertId, concertScheduleId, seatNo);
    }

    @Override
    public List<Long> getNeedExpireReservationIdList(String reserved) {
        return List.of();
    }

    @Override
    public void updateStatus(ReservationDomain domain) {
        ReservationDomain.toDomain(jpaRepository.save(ConcertReserve.toEntity(domain)));
    }

}
