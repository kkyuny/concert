package com.hhdplus.concert.presentation.dto.request;

import com.hhdplus.concert.application.dto.ReservationFacadeDto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequestDto {
    private Long concertId;
    private String title;
    private Long price;
    private LocalDate concertDate;
    private Long seatNo;
    private String status;

    public static ReservationFacadeDto toFacadeDto(ReservationRequestDto dto) {
        return ReservationFacadeDto.builder()
                .build();
    }
}
