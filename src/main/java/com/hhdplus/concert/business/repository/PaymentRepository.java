package com.hhdplus.concert.business.repository;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.PaymentDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;

public interface PaymentRepository {
    void save(PaymentDomain domain);
}
