package com.hhdplus.concert.business.domain;

import com.hhdplus.concert.application.dto.QueueFacadeDto;
import com.hhdplus.concert.infrasturcture.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDomain {
    private Long userId;
    private Long amount;
    private Long price;
    private LocalDateTime regiDate;

    public static UserDomain toDomain(User entity) {
        return UserDomain.builder()
                .userId(entity.getId())
                .amount(entity.getAmount())
                .build();
    }

    public static User toEntity(UserDomain domain) {
        return User.builder()
                .id(domain.getUserId())
                .amount(domain.getAmount())
                .build();
    }
}
