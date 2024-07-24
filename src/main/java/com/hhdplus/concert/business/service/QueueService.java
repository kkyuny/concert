package com.hhdplus.concert.business.service;

import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.repository.QueueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class QueueService {

    private static final int MAX_ACTIVE_USERS = 100;

    static Logger LOGGER = LoggerFactory.getLogger(QueueService.class);

    @Autowired
    private QueueRepository queueRepository;

    public String checkValidToken(QueueDomain domain) {
        String token = domain.getToken();
        Optional<QueueDomain> findByToken = Optional.ofNullable(queueRepository.findByToken(token));

        String result = "";
        if(findByToken.isPresent()){
            result = findByToken.get().getStatus();
        } else {
            result = "notValidToken";
        }
        return result;
    }

    public QueueDomain createToken(QueueDomain domain) {
        String token = UUID.randomUUID().toString().replace("-", "");
        domain.setToken(token);
        domain.setStatus("waiting");

        try{
            queueRepository.save(domain);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("token create error", e);
        }

        return domain;
    }

    public boolean checkQueue(QueueDomain domain) {
        long activeUsersCount = queueRepository.countByStatus("active");

        return activeUsersCount >= MAX_ACTIVE_USERS;
    }

    public QueueDomain getActiveUsersCount(QueueDomain domain) {
        String token = domain.getToken();
        Long myNo = queueRepository.getNoByToken(token);
        domain.setQueueCount((long) queueRepository.findActiveQueues(myNo).size());

        return domain;
    }

    public void changeStatusToActive(QueueDomain domain) {
        try {
            queueRepository.save(domain);
        } catch(Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("token status change error", e);
        }
    }

    public void expireToken(Long userId) {
        try{
            queueRepository.removeToken(userId);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("token create error", e);
        }
    }

    public void activateTokens(List<QueueDomain> activateTargets) {
    }

    public void expireTokens(List<QueueDomain> expireTargets) {
    }

    public List<QueueDomain> findUsersToActivate() {
        return null;
    }

    public List<QueueDomain> findActiveUsersMoreThan5Minutes() {
        return null;
    }
}
