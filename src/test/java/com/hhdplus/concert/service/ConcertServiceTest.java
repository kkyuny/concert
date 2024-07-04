package com.hhdplus.concert.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhdplus.concert.dto.Charge;
import com.hhdplus.concert.dto.Concert;
import com.hhdplus.concert.dto.Payment;
import com.hhdplus.concert.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ConcertServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGenerateToken() throws Exception {
        User user = new User();
        user.setId(1L);
        mockMvc.perform(post("/api/token/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetAvailableDates() throws Exception {
        String token = "testToken";
        mockMvc.perform(get("/api/reservation/dates")
                .header("Authorization", token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetAvailableSeats() throws Exception {
        String token = "testToken";
        String date = "2024-07-15";
        mockMvc.perform(get("/api/reservation/seats")
                        .header("Authorization", token)
                        .param("date", date))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testReserveSeat() throws Exception {
        String token = "testToken";
        Concert concert = new Concert();
        concert.setConcertDate("2024-07-15");
        concert.setSeatNo(1L);
        mockMvc.perform(post("/api/reservation/reserve")
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(concert)))
                .andExpect(status().isOk())
                .andExpect(content().string("예약 성공"));
    }

    @Test
    public void testGetUserAmount() throws Exception {
        User user = new User();
        user.setId(1L);

        mockMvc.perform(get("/api/charge")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    public void testChargeUserAmount() throws Exception {
        Charge charge = new Charge();
        charge.setUserId(1L);
        charge.setAmount(1000L);

        mockMvc.perform(post("/api/charge")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(charge)))
                .andExpect(status().isOk())
                .andExpect(content().string("충전 성공"));
    }

    @Test
    public void testProcessPayment() throws Exception {
        Payment payment = new Payment();
        payment.setUserId(1L);
        payment.setAmount(500L);

        mockMvc.perform(post("/api/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(payment)))
                .andExpect(status().isOk())
                .andExpect(content().string("결제 성공"));
    }
}
