package com.hhdplus.concert.business.service;

import com.hhdplus.concert.business.domain.ChargeDomain;
import com.hhdplus.concert.business.domain.ReservationDomain;
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
public class ChargeService {

    static Logger LOGGER = LoggerFactory.getLogger(ChargeService.class);

    @Autowired
    private ChargeRepository chargeRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveUserAmount(Long userId, Long amount, Long chargeAmount) {
        try {
            userRepository.updateUserAmount(userId, amount + chargeAmount);
            //charge history
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("update user amount error", e);
        }
    }

    public void updateConcertReserveToFinish(ReservationDomain domain) {
        try {
            domain.setStatus("finish");
            chargeRepository.updateConcertReserve(domain);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("update user amount error", e);
        }
    }
}
