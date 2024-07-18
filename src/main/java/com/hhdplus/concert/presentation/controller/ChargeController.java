package com.hhdplus.concert.presentation.controller;

import com.hhdplus.concert.application.facade.ChargeFacade;
import com.hhdplus.concert.presentation.common.exception.InvalidReqBodyException;
import com.hhdplus.concert.presentation.dto.request.ChargeRequestDto;
import com.hhdplus.concert.presentation.dto.request.QueueRequestDto;
import com.hhdplus.concert.presentation.dto.response.ChargeResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/charge")
@Tag(name = "충전", description = "충전 및 조회를 위한 API")
public class ChargeController {
    @Autowired
    ChargeFacade chargeFacade;

    @GetMapping
    @Operation(summary = "잔액 조회", description = "해당 유저의 잔액 조회 API")
    public ChargeResponseDto getUserAmount(@RequestBody ChargeRequestDto dto) {
        return ChargeResponseDto.toResponse(chargeFacade.getUserAmount(ChargeRequestDto.toFacadeDto(dto)));
    }

    @PostMapping
    @Operation(summary = "잔액 충전", description = "해당 유저의 잔액 충전 API")
    public ChargeResponseDto chargeUserAmount(@RequestBody ChargeRequestDto dto) throws InvalidReqBodyException {
        if(dto.getAmount() < 0)
            throw new InvalidReqBodyException("Amount is invalid.");
        return ChargeResponseDto.toResponse(chargeFacade.chargeUserAmount(ChargeRequestDto.toFacadeDto(dto)));
    }
}
