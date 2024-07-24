package com.hhdplus.concert.business.repository;

import com.hhdplus.concert.business.domain.QueueDomain;

import java.util.List;

public interface QueueRepository {
    QueueDomain save(QueueDomain domain);

    QueueDomain findByToken(String token);

    Long countByStatus(String status);

    Long countByStatusNot(String status);

    Long getNoByToken(String token);

    List<String> findActiveQueues(Long myNo);

    void removeToken(Long domain);
}
