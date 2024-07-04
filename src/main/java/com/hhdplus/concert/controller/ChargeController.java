package com.hhdplus.concert.controller;

import com.hhdplus.concert.dto.Charge;
import com.hhdplus.concert.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/charge")
public class ChargeController {

    @GetMapping
    public ResponseEntity<User> getUserAmount(@RequestBody User user) {
        // 잔액 조회
        //User result = userService.getUserAmount(user);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<String> chargeUserAmount(@RequestBody Charge charge) {
        // 잔액 충전
        //userService.chargeUserAmount(user);

        return ResponseEntity.ok("충전 성공");
    }
}
