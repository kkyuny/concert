package com.hhdplus.concert.business.domain;

import com.hhdplus.concert.infrasturcture.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueDomain {
    private Long no;
    private Long userId;
    private String token;
    private String status;
    private LocalDateTime validTime;
    private LocalDateTime regiDate;
    private Long queueCount;
    private String checkToken;
    private List<String> queueCountList;

    public static UserDomain toDomain(User entity) {
        return UserDomain.builder()
                .userId(entity.getId())
                .build();
    }

    public static User toEntity(UserDomain domain) {
        return User.builder()
                .id(domain.getUserId())
                .build();
    }

}
