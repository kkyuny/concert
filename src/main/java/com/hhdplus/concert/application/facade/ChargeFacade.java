package com.hhdplus.concert.application.facade;

import com.hhdplus.concert.application.dto.ChargeFacadeDto;
import com.hhdplus.concert.application.dto.PaymentFacadeDto;
import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.domain.UserDomain;
import com.hhdplus.concert.business.service.ChargeService;
import com.hhdplus.concert.business.service.UserService;
import com.hhdplus.concert.interfaces.presentation.common.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChargeFacade {

    @Autowired
    ChargeService chargeService;

    @Autowired
    UserService userService;

    public ChargeFacadeDto chargeUserAmount(ChargeFacadeDto dto){
        Optional<UserDomain> user = Optional.ofNullable(userService.getUserById(dto.getUserId()));

        if(user.isEmpty())
            throw new BadRequestException("유저 정보 없음");

        // chargeService.saveHistory();
        userService.updateUserAmount(user.get().getUserId(), user.get().getAmount() + dto.getAmount());

        return dto;
    }
}
