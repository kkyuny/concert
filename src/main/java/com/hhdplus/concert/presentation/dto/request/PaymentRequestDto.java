package com.hhdplus.concert.presentation.dto.request;

import com.hhdplus.concert.application.dto.PaymentFacadeDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDto {
    private Long id;
    private Long userId;
    private Long concertId;
    private Long amount;

    public static PaymentFacadeDto toFacadeDto(PaymentRequestDto dto) {
        return PaymentFacadeDto.builder()
                .userId(dto.getUserId())
                .concertId(dto.getConcertId())
                .amount(dto.getAmount())
                .build();
    }

}
