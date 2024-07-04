package com.hhdplus.concert.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    private Long id;
    private Long userId;
    private Long amount;
}
