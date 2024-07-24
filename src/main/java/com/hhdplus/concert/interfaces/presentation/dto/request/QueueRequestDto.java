package com.hhdplus.concert.interfaces.presentation.dto.request;

import com.hhdplus.concert.application.dto.QueueFacadeDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueRequestDto {
    private Long userId;
    private String token;
    private String status;

    public static QueueFacadeDto toFacadeDto(QueueRequestDto dto) {
        return QueueFacadeDto.builder()
                .userId(dto.getUserId())
                .token(dto.getToken())
                .status(dto.getStatus())
                .build();
    }
}
