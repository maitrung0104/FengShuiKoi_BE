package com.example.FengShuiKoi.controller;
import com.example.FengShuiKoi.entity.Koi;

import com.example.FengShuiKoi.model.KoiRequest;
import com.example.FengShuiKoi.service.KoiService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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




    @PostMapping
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity create(@RequestBody Koi koi) {
        Koi newKoi = koiService.create(koi);
        return ResponseEntity.ok(newKoi);
    }


    @GetMapping
    public ResponseEntity getAll() {
        List<Koi> koi = koiService.getAll();
        return ResponseEntity.ok(koi);
    }



    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody KoiRequest koiRequest) {
        Koi updateKoi = koiService.update(id, koiRequest);
        return ResponseEntity.ok(updateKoi);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('OWNER')")
    public void deleteKoi(@PathVariable UUID id) {
        koiService.deleteKoi(id);
    }
}

