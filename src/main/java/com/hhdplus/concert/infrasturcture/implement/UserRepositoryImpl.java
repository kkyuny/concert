package com.hhdplus.concert.infrasturcture.implement;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.UserDomain;
import com.hhdplus.concert.business.repository.ChargeRepository;
import com.hhdplus.concert.business.repository.UserRepository;
import com.hhdplus.concert.infrasturcture.repository.ChargeJpaRepository;
import com.hhdplus.concert.infrasturcture.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserJpaRepository jpaRepository;

    @Override
    public UserDomain getAmountByUserId(Long userId) {
        return UserDomain.toDomain(jpaRepository.getAmountByUserId(userId));
    }

    @Override
    public void updateUserAmount(Long userId, Long price) {
        jpaRepository.updateUserAmount(userId, price);
    }
}
