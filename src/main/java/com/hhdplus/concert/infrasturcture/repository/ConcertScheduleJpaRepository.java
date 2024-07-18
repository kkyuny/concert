package com.hhdplus.concert.infrasturcture.repository;

import com.hhdplus.concert.infrasturcture.entity.ConcertReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConcertScheduleJpaRepository extends JpaRepository<ConcertReserve, Long> {
}
