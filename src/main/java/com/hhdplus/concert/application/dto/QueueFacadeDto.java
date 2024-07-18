package com.hhdplus.concert.application.dto;

import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.domain.UserDomain;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueFacadeDto {
    private Long no;
    private Long userId;
    private String token;
    private String status;
    private LocalDateTime validTime;
    private LocalDateTime regiDate;
    private Long queueCount;
    private String checkToken;

    public static QueueDomain toDomain(QueueFacadeDto dto) {
        return QueueDomain.builder()
                .userId(dto.getUserId())
                .token(dto.getToken())
                .status(dto.getStatus())
                .no(dto.getNo())
                .build();
    }

    public static QueueFacadeDto toFacadeDto(QueueDomain domain) {
        return QueueFacadeDto.builder()
                .userId(domain.getUserId())
                .token(domain.getToken())
                .status(domain.getStatus())
                .no(domain.getNo())
                .queueCount(domain.getQueueCount())
                .checkToken(domain.getCheckToken())
                .build();
    }


}
