package com.hhdplus.concert.infrasturcture.repository;

import com.hhdplus.concert.infrasturcture.entity.ConcertReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hhdplus.concert.infrasturcture.entity.Charge;

@Repository
public interface ChargeJpaRepository extends JpaRepository<Charge, Long> {

    void updateConcertReserve(ConcertReserve entity);
}
