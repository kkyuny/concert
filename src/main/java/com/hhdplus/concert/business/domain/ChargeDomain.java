package com.hhdplus.concert.business.domain;

import com.hhdplus.concert.infrasturcture.entity.Charge;
import com.hhdplus.concert.infrasturcture.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeDomain {
    private Long userId;
    private Long amount;
    private LocalDateTime regiDate;

    public static ChargeDomain toDomain(Charge entity) {
        return ChargeDomain.builder()
                .userId(entity.getId())
                .amount(entity.getAmount())
                .build();
    }

    public static Charge toEntity(ChargeDomain domain) {
        return Charge.builder()
                .id(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }
}
