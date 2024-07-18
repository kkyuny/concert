package com.hhdplus.concert.infrasturcture.implement;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.repository.ChargeRepository;
import com.hhdplus.concert.business.repository.QueueRepository;
import com.hhdplus.concert.infrasturcture.entity.Charge;
import com.hhdplus.concert.infrasturcture.entity.Queue;
import com.hhdplus.concert.infrasturcture.repository.ChargeJpaRepository;
import com.hhdplus.concert.infrasturcture.repository.QueueJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChargeRepositoryImpl implements ChargeRepository {
    @Autowired
    private ChargeJpaRepository jpaRepository;

    @Override
    public void save(ChargeDomain domain) {
    }

    @Override
    public void updateConcertReserve(ReservationDomain domain) {
        jpaRepository.updateConcertReserve(ReservationDomain.toEntity(domain));
    }
}
