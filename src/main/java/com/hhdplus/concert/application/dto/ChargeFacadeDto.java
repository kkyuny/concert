package com.hhdplus.concert.application.dto;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.domain.UserDomain;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeFacadeDto {
    private Long userId;
    private Long amount;

    public static ChargeDomain toDomain(ChargeFacadeDto dto) {
        return ChargeDomain.builder()
                .userId(dto.getUserId())
                .amount(dto.amount)
                .build();
    }

    public static ChargeFacadeDto toFacadeDto(ChargeDomain domain) {
        return ChargeFacadeDto.builder()
                .userId(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }

    public static UserDomain toUserDomain(ChargeFacadeDto dto) {
        return UserDomain.builder()
                .userId(dto.getUserId())
                .amount(dto.amount)
                .build();
    }

    public static ChargeFacadeDto toChargeFacadeDto(UserDomain domain) {
        return ChargeFacadeDto.builder()
                .userId(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }
}
