package com.hhdplus.concert.application.dto;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.PaymentDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.domain.UserDomain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentFacadeDto {
    private Long userId;
    private Long amount;
    private Long price;
    private Long concertId;
    private String status;
    private boolean paymentResult;

    public static PaymentDomain toDomain(PaymentFacadeDto dto) {
        return PaymentDomain.builder()
                .userId(dto.getUserId())
                .amount(dto.amount)
                .build();
    }

    public static PaymentFacadeDto toFacadeDto(PaymentDomain domain) {
        return PaymentFacadeDto.builder()
                .userId(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }

    public static PaymentFacadeDto toPaymentFacadeDto(UserDomain domain) {
        return PaymentFacadeDto.builder()
                .userId(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }

    public static ReservationDomain toReservationDomain(PaymentFacadeDto dto) {
        return ReservationDomain.builder()
                .userId(dto.getUserId())
                .status(dto.getStatus())
                .build();
    }

    public static UserDomain toUserDomain(PaymentFacadeDto dto) {
        return null;
    }
}
