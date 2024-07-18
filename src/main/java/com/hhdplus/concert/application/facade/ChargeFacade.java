package com.hhdplus.concert.application.facade;

import com.hhdplus.concert.application.dto.ChargeFacadeDto;
import com.hhdplus.concert.business.service.ChargeService;
import com.hhdplus.concert.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChargeFacade {

    @Autowired
    ChargeService chargeService;

    @Autowired
    UserService userService;

    public ChargeFacadeDto getUserAmount(ChargeFacadeDto dto){
        return ChargeFacadeDto.toChargeFacadeDto(userService.getUserAmount(ChargeFacadeDto.toUserDomain(dto)));
    }

    public ChargeFacadeDto chargeUserAmount(ChargeFacadeDto dto){
        chargeService.saveUserAmount(ChargeFacadeDto.toDomain(dto));
        userService.updateUserAmount(ChargeFacadeDto.toUserDomain(dto));

        return dto;
    }
}
