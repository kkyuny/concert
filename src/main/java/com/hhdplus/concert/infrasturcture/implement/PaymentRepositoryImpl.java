package com.hhdplus.concert.infrasturcture.implement;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.PaymentDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.business.repository.ChargeRepository;
import com.hhdplus.concert.business.repository.PaymentRepository;
import com.hhdplus.concert.infrasturcture.repository.ChargeJpaRepository;
import com.hhdplus.concert.infrasturcture.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    @Autowired
    private PaymentJpaRepository jpaRepository;

    @Override
    public void save(PaymentDomain domain) {
        jpaRepository.save(PaymentDomain.toEntity(domain));
    }
}
