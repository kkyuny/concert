package com.hhdplus.concert.infrasturcture.implement;

import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.repository.QueueRepository;
import com.hhdplus.concert.infrasturcture.entity.Queue;
import com.hhdplus.concert.infrasturcture.repository.QueueJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueueRepositoryImpl implements QueueRepository {
    @Autowired
    private QueueJpaRepository jpaRepository;

    @Override
    public QueueDomain save(QueueDomain domain) {
        return Queue.toDomain(jpaRepository.save(Queue.toEntity(domain)));
    }

    @Override
    public QueueDomain findByToken(String token) {
        return null;
    }

    @Override
    public Long countByStatus(String status) {
        return jpaRepository.countByStatus("active");
    }

    @Override
    public Long countByStatusNot(String status) {
        return jpaRepository.countByStatusNot("active");
    }

    @Override
    public Long getNoByToken(String token) {
        return jpaRepository.getNoByToken(token);
    }

    @Override
    public List<String> findActiveQueues(Long myNo) {
        return jpaRepository.findActiveQueues(myNo);
    }
}
