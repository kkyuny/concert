package com.hhdplus.concert.interfaces.presentation.dto.response;

import com.hhdplus.concert.application.dto.PaymentFacadeDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDto {
    private Long id;
    private Long userId;
    private Long amount;
    private Long concertId;

    public static PaymentResponseDto toResponse(PaymentFacadeDto dto) {
        return PaymentResponseDto.builder()
                .userId(dto.getUserId())
                .amount(dto.getAmount())
                .build();
    }
}
