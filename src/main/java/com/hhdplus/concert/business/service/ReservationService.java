package com.hhdplus.concert.business.service;

import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.repository.ConcertRepository;
import com.hhdplus.concert.business.repository.ConcertReserveRepository;
import com.hhdplus.concert.business.repository.ConcertScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class ReservationService {

    static Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ConcertScheduleRepository concertScheduleRepository;

    @Autowired
    private ConcertReserveRepository concertReserveRepository;

    public ReservationDomain getAvailableDates(ReservationDomain domain) {
        Long concertId = domain.getConcertId();
        domain.setAvailableDates(concertReserveRepository.findAvailableDatesByConcertId(concertId));

        return domain;
    }

    public ReservationDomain getAvailableSeats(ReservationDomain domain) {
        Long concertId = domain.getConcertId();
        LocalDate date = domain.getConcertDate();

        List<Long> reservedSeatNos = concertReserveRepository.findAvailableSeatByConcertIdAndDate(concertId, date);
        List<Long> availableSeats = LongStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());

        availableSeats.removeAll(reservedSeatNos);
        domain.setAvailableSeats(availableSeats);

        return domain;
    }

    public void reserveSeat(ReservationDomain domain) {
        try {
            concertReserveRepository.save(domain);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("reserve seat error", e);
        }
    }

    public ReservationDomain getUserReserve(ReservationDomain domain){
        Long concertId = domain.getConcertId();
        Long concertScheduleId = domain.getConcertScheduleId();
        Long seatNo = domain.getSeatNo();

        return concertReserveRepository.getUserReserveStatus(concertId, concertScheduleId, seatNo);
    }
}
