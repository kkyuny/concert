package com.hhdplus.concert.application.facade;

import com.hhdplus.concert.application.dto.ChargeFacadeDto;
import com.hhdplus.concert.application.dto.PaymentFacadeDto;
import com.hhdplus.concert.application.dto.ReservationFacadeDto;
import com.hhdplus.concert.application.dto.UserFacadeDto;
import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.domain.UserDomain;
import com.hhdplus.concert.business.service.*;
import com.hhdplus.concert.interfaces.presentation.common.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentFacade {

    @Autowired
    ChargeService chargeService;

    @Autowired
    UserService userService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    QueueService queueService;

    public PaymentFacadeDto requestPayment(PaymentFacadeDto dto){
        Optional<ReservationDomain> reservation = Optional.ofNullable(reservationService.getUserReserve(PaymentFacadeDto.toReservationDomain(dto)));

        if(reservation.isEmpty())
            throw new BadRequestException("예약 정보 없음");

        if(reservation.get().getStatus().equals("waiting")){
            UserDomain user = userService.getUserById(reservation.get().getUserId());

            // 결제 진행 중에 토큰이 만료되어서 새로운 예약이 발생하는 것을 방지해야함?
            userService.updateUserAmount(reservation.get().getUserId(), user.getAmount() - reservation.get().getPrice());
            paymentService.savePayment(PaymentFacadeDto.toDomain(dto));
            chargeService.updateConcertReserveToFinish(reservation.get());
            queueService.expireToken(user.getUserId());

        } else {
            throw new BadRequestException("Status is not waiting");
        }

        return dto;
    }
}
