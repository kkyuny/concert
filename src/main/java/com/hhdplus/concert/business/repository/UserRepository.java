package com.hhdplus.concert.business.repository;

import com.hhdplus.concert.business.domain.UserDomain;

public interface UserRepository {
    UserDomain getAmountByUserId(Long userId);

    void updateUserAmount(Long userId, Long price);
}
