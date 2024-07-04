package com.hhdplus.concert.controller;

import com.hhdplus.concert.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/token")
public class TokenController {

    @PostMapping("/create")
    public ResponseEntity<String> generateToken(@RequestBody User user) {
        //String token = UUID.randomUUID().toString();

        String token = "";
        return ResponseEntity.ok(token);
    }
}
