package com.hhdplus.concert.application.dto;

import com.hhdplus.concert.business.domain.UserDomain;
import com.hhdplus.concert.infrasturcture.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFacadeDto {
    private Long userId;
    private Long amount;
    private Long price;
    private LocalDateTime regiDate;

    public static UserDomain toDomain(UserFacadeDto dto) {
        return UserDomain.builder()
                .userId(dto.getUserId())
                .amount(dto.getAmount())
                .build();
    }

    public static UserFacadeDto toFacadeDto(UserDomain domain) {
        return UserFacadeDto.builder()
                .userId(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }
}
