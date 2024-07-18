package com.hhdplus.concert.application.facade;

import com.hhdplus.concert.application.dto.ChargeFacadeDto;
import com.hhdplus.concert.application.dto.PaymentFacadeDto;
import com.hhdplus.concert.application.dto.ReservationFacadeDto;
import com.hhdplus.concert.business.service.ChargeService;
import com.hhdplus.concert.business.service.PaymentService;
import com.hhdplus.concert.business.service.ReservationService;
import com.hhdplus.concert.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public PaymentFacadeDto requestPayment(PaymentFacadeDto dto){
        ReservationFacadeDto reserveDto = ReservationFacadeDto.toFacadeDto(reservationService.getUserReserve(PaymentFacadeDto.toReservationDomain(dto)));

        if(reserveDto.getStatus().equals("waiting")){
            userService.updateUserAmount(ReservationFacadeDto.toUserDomain(reserveDto));
            chargeService.updateConcertReserve(ReservationFacadeDto.toDomain(reserveDto));
            paymentService.savePayment(PaymentFacadeDto.toDomain(dto));

            dto.setPaymentResult(true);
        } else {
            dto.setPaymentResult(false);
        }

        return dto;
    }
}
