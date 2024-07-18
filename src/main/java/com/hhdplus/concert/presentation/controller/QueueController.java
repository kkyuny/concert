package com.hhdplus.concert.presentation.controller;

import com.hhdplus.concert.application.facade.QueueFacade;
import com.hhdplus.concert.presentation.dto.request.QueueRequestDto;
import com.hhdplus.concert.presentation.dto.response.QueueResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/token")
@Tag(name = "토큰", description = "토큰 생성 및 Queue 상태 조회 API")
public class QueueController {

    @Autowired
    QueueFacade queueFacade;

    @PostMapping("/create")
    @Operation(summary = "토큰 생성", description = "토큰 생성 API")
    public QueueResponseDto generateToken(@RequestBody QueueRequestDto dto) {
        return QueueResponseDto.toResponse(queueFacade.createToken(QueueRequestDto.toFacadeDto(dto)));
    }

    @GetMapping("/check")
    @Operation(summary = "Queue 상태 조회", description = "Queue 상태 조회 API")
    public QueueResponseDto checkQueue(@RequestBody QueueRequestDto dto) {
        return QueueResponseDto.toResponse(queueFacade.countQueue(QueueRequestDto.toFacadeDto(dto)));
    }
}
