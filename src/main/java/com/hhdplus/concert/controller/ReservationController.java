package com.hhdplus.concert.controller;

import com.hhdplus.concert.dto.Concert;
import com.hhdplus.concert.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    @GetMapping("/dates")
    public ResponseEntity<List<LocalDate>> getAvailableDates() {
        // 예약 가능한 날짜 목록 반환
        // List<LocalDate> availableDates = reservationService.getAvailableDates();

        List<LocalDate> availableDates = new ArrayList<>();

        availableDates.add(LocalDate.parse("2024-05-15"));
        availableDates.add(LocalDate.parse("2024-05-16"));

        return ResponseEntity.ok(availableDates);
    }

    @GetMapping("/seats")
    public ResponseEntity<List<Integer>> getAvailableSeats(@RequestParam String date) {
        // 특정 날짜의 예약 가능한 좌석 목록 반환
        // List<Integer> availableSeats = reservationService.getAvailableSeats(date);
        List<Integer> availableSeats = new ArrayList<>();

        availableSeats.add(1);
        availableSeats.add(2);
        availableSeats.add(3);
        availableSeats.add(4);
        availableSeats.add(5);

        return ResponseEntity.ok(availableSeats);
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserveSeat(@RequestBody Concert concert) {
        // 특정 날짜와 좌석에 대한 예약 처리
        String result = "예약 성공";
        return ResponseEntity.ok(result);
    }
}
