package com.hhdplus.concert.infrasturcture.repository;

import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.infrasturcture.entity.Concert;
import com.hhdplus.concert.infrasturcture.entity.ConcertReserve;
import com.hhdplus.concert.infrasturcture.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConcertJpaRepository extends JpaRepository<Concert, Long> {
}
