package com.hhdplus.concert.infrasturcture.entity;

import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;
import jakarta.persistence.*;
import lombok.*;
import org.h2.schema.Domain;

import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table(name = "concert_reserve")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConcertReserve {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private Long concertId;
    @Id
    private Long concertScheduleId;
    @Id
    private Long seatNo;

    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private ConcertSchedule schedule;

    @ManyToOne
    @JoinColumn(name = "concert_id", insertable = false, updatable = false)
    private Concert concert;

    public static ConcertReserve toEntity(ReservationDomain domain){
        return ConcertReserve.builder()
                .build();
    }

    public static ReservationDomain toDomain(ConcertReserve entity) {
        return ReservationDomain.builder()
                .build();
    }
}
