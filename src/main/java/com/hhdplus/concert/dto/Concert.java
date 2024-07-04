package com.hhdplus.concert.dto;

import lombok.*;

import java.time.DateTimeException;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Concert {
    private Long id;
    private Long lastSeatNo;
    private Long seatNo;
    private String concertDate;
}
