package com.hhdplus.concert.interfaces.scheduler;

import com.hhdplus.concert.application.facade.QueueFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueScheduler {
    @Autowired
    QueueFacade queueFacade;

    @Scheduled(fixedDelay = 3*60)
    public void activateTokens() {
        queueFacade.activateTokens();
    }

    @Scheduled(fixedDelay = 5*60)
    public void expireTokens() {
        queueFacade.expireTokens();
    }
}
