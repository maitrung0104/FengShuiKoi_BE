package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.service.CanChiService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/canchi")
@SecurityRequirement(name="api")
public class CanChiAPI {
    @Autowired
    CanChiService canChiService;
    @GetMapping("/menh")
    public String getMenh(@RequestParam String date) {
        try {
            // Chuyển đổi từ định dạng dd/MM/yyyy sang LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateOfBirth = LocalDate.parse(date, formatter);

            // Chuyển đổi sang lịch âm và lấy năm
            int lunarYear = canChiService.convertToLunar(dateOfBirth).getYear();

            // Tính toán mệnh và trả về kết quả
            return canChiService.calculateMenh(lunarYear); // Phải chắc chắn phương thức này trả về String
        } catch (DateTimeParseException e) {
            return "Ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.";
        }
    }
}
