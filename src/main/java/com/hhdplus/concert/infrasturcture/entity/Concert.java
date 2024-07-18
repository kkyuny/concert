package com.hhdplus.concert.infrasturcture.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "concert")
    private List<ConcertSchedule> schedules;

    @OneToMany(mappedBy = "concert")
    private List<ConcertReserve> reservations;
}
