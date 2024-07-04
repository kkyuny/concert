package com.hhdplus.concert.controller;

import com.hhdplus.concert.dto.Concert;
import com.hhdplus.concert.dto.Payment;
import com.hhdplus.concert.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody Payment payment) {
        // 결제 요청
        //paymentService.processPayment(user);

        return ResponseEntity.ok("결제 성공");
    }
}
