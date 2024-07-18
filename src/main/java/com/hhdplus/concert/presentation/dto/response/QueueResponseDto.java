package com.hhdplus.concert.presentation.dto.response;

import com.hhdplus.concert.application.dto.QueueFacadeDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueResponseDto {
    private Long no;
    private Long userId;
    private String token;
    private String status;
    private LocalDateTime validTime;
    private LocalDateTime regiDate;
    private Long queueCount;

    public static QueueResponseDto toResponse(QueueFacadeDto dto) {
        return QueueResponseDto.builder()
                .userId(dto.getUserId())
                .token(dto.getToken())
                .status(dto.getStatus())
                .no(dto.getNo())
                .validTime(dto.getValidTime())
                .queueCount(dto.getQueueCount())
                .build();
    }
}
