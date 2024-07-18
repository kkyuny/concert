package com.hhdplus.concert.infrasturcture.implement;

import com.hhdplus.concert.business.repository.ConcertRepository;
import com.hhdplus.concert.infrasturcture.repository.ConcertJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConcertRepositoryImpl implements ConcertRepository {
    @Autowired
    private ConcertJpaRepository jpaRepository;
}
