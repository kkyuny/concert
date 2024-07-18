package com.hhdplus.concert.business.service;

import com.hhdplus.concert.business.domain.UserDomain;
import com.hhdplus.concert.business.repository.ChargeRepository;
import com.hhdplus.concert.business.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserService {

    static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserDomain getUserAmount(UserDomain domain) {
        Long userId = domain.getUserId();
        return userRepository.getAmountByUserId(userId);
    }

    public void updateUserAmount(UserDomain domain) {
        Long userId = domain.getUserId();
        Long price = domain.getPrice();

        try {
            userRepository.updateUserAmount(userId, price);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("update user amount error", e);
        }
    }
}
