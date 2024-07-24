package com.hhdplus.concert.application.facade;

import com.hhdplus.concert.application.dto.QueueFacadeDto;
import com.hhdplus.concert.business.domain.QueueDomain;
import com.hhdplus.concert.business.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class QueueFacade {

    @Autowired
    QueueService queueService;

    public QueueFacadeDto createToken(QueueFacadeDto dto) {
        return QueueFacadeDto.toFacadeDto(queueService.createToken(QueueFacadeDto.toDomain(dto)));
    }

    public QueueFacadeDto countQueue(QueueFacadeDto dto) {
        dto.setQueueCount((long) queueService.getActiveUsersCount(QueueFacadeDto.toDomain(dto)).getQueueCountList().size());

        return QueueFacadeDto.toFacadeDto(QueueFacadeDto.toDomain(dto));
    }

    public QueueFacadeDto checkToken(QueueFacadeDto dto){
        String tokenStatus = queueService.checkValidToken(QueueFacadeDto.toDomain(dto));

        if("active".equals(tokenStatus)){
            dto.setCheckToken("allowAccess");
        } else if("waiting".equals(tokenStatus)){
            if(queueService.checkQueue(QueueFacadeDto.toDomain(dto))){
                queueService.changeStatusToActive(QueueFacadeDto.toDomain(dto));
                dto.setCheckToken("allowAccess");
            } else
                dto.setCheckToken("fullWaitingQueue");
        } else
            dto.setCheckToken("notValidToken");

        return QueueFacadeDto.toFacadeDto(QueueFacadeDto.toDomain(dto));
    }

    public void activateTokens() {
        List<QueueDomain> activateTargets = queueService.findUsersToActivate();
        queueService.activateTokens(activateTargets);
    }

    public void expireTokens() {
        List<QueueDomain> expireTargets = queueService.findActiveUsersMoreThan5Minutes();
        queueService.expireTokens(expireTargets);
    }
}
