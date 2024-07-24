package com.hhdplus.concert.interfaces.presentation.dto.response;

import com.hhdplus.concert.application.dto.ReservationFacadeDto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponseDto {
    private Long concertId;
    private String title;
    private Long price;
    private LocalDate concertDate;
    private Long seatNo;
    private String status;

    public static ReservationResponseDto toResponse(ReservationFacadeDto dto) {
        return ReservationResponseDto.builder()
                .build();
    }
}
