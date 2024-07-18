package com.hhdplus.concert.infrasturcture.repository;

import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.infrasturcture.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QueueJpaRepository extends JpaRepository<Queue, Long> {
    Optional<Queue> findByToken(String token);

    Long countByStatus(String status);

    Long countByStatusNot(String status);

    Long getNoByToken(String token);

    @Query("SELECT token FROM Queue q WHERE q.no < :myNo AND q.status = 'active'")
    List<String> findActiveQueues(@Param("myNo") Long myNo);
}
