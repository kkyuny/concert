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
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class QueueService {

    private static final int MAX_ACTIVE_USERS = 100;
    private static final int MAX_ACTIVE_MINUTES = 5;

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

    public void expireTokens(List<QueueDomain> expireTargets) {
    }

    public List<QueueDomain> findActiveUsersMoreThan5Minutes() {
        return null;
    }

    public List<QueueDomain> findUsersToActivate() {
        // Fetch all users with 'waiting' status
        List<QueueDomain> waitingUsers = queueRepository.findUsersByStatus("waiting");

        // Sort by creationDate to get the oldest tokens first
        List<QueueDomain> sortedWaitingUsers = waitingUsers.stream()
                .sorted((u1, u2) -> u1.getRegiDate().compareTo(u2.getRegiDate()))
                .collect(Collectors.toList());

        // Return up to 100 users
        return sortedWaitingUsers.stream().limit(100).collect(Collectors.toList());
    }

    public void activateTokens(List<QueueDomain> activateTargets) {
        for (QueueDomain user : activateTargets) {
            user.setStatus("active");
            queueRepository.save(user); // Save the updated user status
        }
    }


}
