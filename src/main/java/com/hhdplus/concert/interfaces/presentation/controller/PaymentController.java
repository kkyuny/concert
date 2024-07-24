package com.hhdplus.concert.interfaces.presentation.controller;

import com.hhdplus.concert.application.facade.PaymentFacade;
import com.hhdplus.concert.interfaces.presentation.common.exception.InvalidReqBodyException;
import com.hhdplus.concert.interfaces.presentation.dto.request.PaymentRequestDto;
import com.hhdplus.concert.interfaces.presentation.dto.response.PaymentResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payment")
@Tag(name = "결제", description = "결제를 위한 API")
public class PaymentController {
    @Autowired
    PaymentFacade paymentFacade;

    @PostMapping
    @Operation(summary = "결제 요청", description = "예약 내역에 대한 결제요청 API")
    public PaymentResponseDto processPayment(@RequestBody PaymentRequestDto dto) throws InvalidReqBodyException {
        if(dto.getAmount() < 0)
            throw new InvalidReqBodyException("Amount is invalid.");
        return PaymentResponseDto.toResponse(paymentFacade.requestPayment(PaymentRequestDto.toFacadeDto(dto)));
    }
}
