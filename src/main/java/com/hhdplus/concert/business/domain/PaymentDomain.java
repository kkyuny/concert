package com.hhdplus.concert.business.domain;

import com.hhdplus.concert.infrasturcture.entity.Charge;
import com.hhdplus.concert.infrasturcture.entity.Payment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDomain {
    private Long userId;
    private Long amount;
    private Long concertId;
    private LocalDateTime regiDate;

    public static PaymentDomain toDomain(Payment entity) {
        return PaymentDomain.builder()
                .userId(entity.getId())
                .amount(entity.getAmount())
                .concertId(entity.getConcertId())
                .build();
    }

    public static Payment toEntity(PaymentDomain domain) {
        return Payment.builder()
                .id(domain.getUserId())
                .amount(domain.getAmount())
                .concertId(domain.getConcertId())
                .build();
    }
}
