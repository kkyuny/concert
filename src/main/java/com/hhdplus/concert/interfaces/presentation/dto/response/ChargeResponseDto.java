package com.hhdplus.concert.interfaces.presentation.dto.response;

import com.hhdplus.concert.application.dto.ChargeFacadeDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeResponseDto {
    private Long id;
    private Long userId;
    private Long amount;

    public static ChargeResponseDto toResponse(ChargeFacadeDto dto) {
        return ChargeResponseDto.builder()
                .userId(dto.getUserId())
                .amount(dto.getAmount())
                .build();
    }
}
