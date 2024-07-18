package com.hhdplus.concert.business.repository;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.infrasturcture.entity.Charge;

import java.util.List;

public interface ChargeRepository {
    void save(ChargeDomain domain);

    void updateConcertReserve(ReservationDomain domain);
}
