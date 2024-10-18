package com.example.FengShuiKoi.controller;
import com.example.FengShuiKoi.entity.Koi;

import com.example.FengShuiKoi.service.KoiService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/koi")
@SecurityRequirement(name = "api")
@CrossOrigin(origins = "*")
public class KoiController {

    @Autowired
    KoiService koiService;



    // 1. API lấy danh sách lên -> phân trang ở back-end


    // 2. Tạo và lưu đơn hàng
    @PostMapping
    public ResponseEntity create(@RequestBody Koi koi) {
        Koi newKoi = koiService.create(koi);
        return ResponseEntity.ok(newKoi);
    }

    // 3. Lịch sử mua hàng
    @GetMapping
    public ResponseEntity getAll() {
        List<Koi> koi = koiService.getAll();
        return ResponseEntity.ok(koi);
    }



    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody Koi koi) {
        Koi updateKoi = koiService.update(id, koi);
        return ResponseEntity.ok(updateKoi);
    }

    @DeleteMapping("/{id}")
    public void deleteKoi(@PathVariable UUID id) {
        koiService.deleteKoi(id);
    }
}

