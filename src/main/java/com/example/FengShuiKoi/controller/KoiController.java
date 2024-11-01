package com.example.FengShuiKoi.controller;
import com.example.FengShuiKoi.entity.Element;
import com.example.FengShuiKoi.entity.Koi;

import com.example.FengShuiKoi.model.KoiRequest;
import com.example.FengShuiKoi.repos.ElementRepository;
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

    @Autowired
    ElementRepository elementRepository;


    @PostMapping

    @PreAuthorize("hasAuthority('OWNER')")
    public ResponseEntity create(@RequestBody Koi koi) {
        Element element = elementRepository.findByName(koi.getElement());
        if (element == null) {
            element = new Element();
            element.setName(koi.getElement());
            elementRepository.save(element);
        }

        // Gán ID mệnh vào cá Koi
        koi.setElement(element.getName());
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

