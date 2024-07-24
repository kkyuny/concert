package com.hhdplus.concert.interfaces.presentation.dto.request;

import com.hhdplus.concert.application.dto.ChargeFacadeDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargeRequestDto {
    private Long id;
    private Long userId;
    private Long amount;

    public static ChargeFacadeDto toFacadeDto(ChargeRequestDto dto) {
        return ChargeFacadeDto.builder()
                .userId(dto.getUserId())
                .amount(dto.getAmount())
                .build();
    }
}
