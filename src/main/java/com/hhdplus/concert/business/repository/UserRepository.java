package com.hhdplus.concert.business.repository;

import com.hhdplus.concert.application.dto.UserFacadeDto;
import com.hhdplus.concert.business.domain.UserDomain;
import com.hhdplus.concert.infrasturcture.entity.User;

public interface UserRepository {
    void updateUserAmount(Long userId, Long price);

    UserDomain getUserById(Long userId);
}
