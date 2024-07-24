package com.hhdplus.concert.infrasturcture.repository;

import com.hhdplus.concert.application.dto.UserFacadeDto;
import com.hhdplus.concert.business.domain.UserDomain;
import com.hhdplus.concert.infrasturcture.entity.Charge;
import com.hhdplus.concert.infrasturcture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    Long getAmountByUserId(Long userId);

    @Modifying
    @Query("UPDATE user SET amount = amount + :price WHERE userId = :userId")
    void updateUserAmount(@Param("userId") Long userId, @Param("price") Long price);

    User getUserById(Long userId);
}
