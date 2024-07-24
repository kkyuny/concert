package com.hhdplus.concert.interfaces.scheduler;

import com.hhdplus.concert.application.facade.ReservationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationScheduler {
    private final ReservationFacade reservationFacade;

    @Scheduled(fixedDelay = 5000)
    public void cancelReservation() {
        reservationFacade.cancelReservation();
    }
}
