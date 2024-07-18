package com.hhdplus.concert.infrasturcture.repository;

import com.hhdplus.concert.infrasturcture.entity.Charge;
import com.hhdplus.concert.infrasturcture.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {

}
