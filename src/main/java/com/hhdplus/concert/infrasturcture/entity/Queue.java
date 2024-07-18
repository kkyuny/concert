package com.hhdplus.concert.infrasturcture.entity;

import com.hhdplus.concert.business.domain.QueueDomain;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "queue")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String status;
    private String token;

    public static Queue toEntity(QueueDomain domain){
        return Queue.builder()
                .id(domain.getNo())
                .userId(domain.getUserId())
                .token(domain.getToken())
                .status(domain.getStatus())
                .build();
    }

    public static QueueDomain toDomain(Queue entity) {
        return QueueDomain.builder()
                .no(entity.getId())
                .userId(entity.getUserId())
                .token(entity.getToken())
                .status(entity.getStatus())
                .build();
    }

}
