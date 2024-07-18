package com.hhdplus.concert.infrasturcture.entity;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "chargeHistory")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long amount;
    private LocalDateTime regiDate;

    public static Charge toEntity(ChargeDomain domain){
        return Charge.builder()
                .userId(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }

    public static ChargeDomain toDomain(Charge entity) {
        return ChargeDomain.builder()
                .userId(entity.getUserId())
                .amount(entity.getAmount())
                .build();
    }
}
