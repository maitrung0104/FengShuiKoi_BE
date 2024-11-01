package com.example.FengShuiKoi.controller;
import com.example.FengShuiKoi.entity.Koi;
import com.example.FengShuiKoi.entity.KoiFishPond;
import com.example.FengShuiKoi.entity.LakeDirection;
import com.example.FengShuiKoi.service.InfoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/info") // Cập nhật đường dẫn request
@SecurityRequirement(name = "api")
public class InfoController {

    @Autowired
    InfoService infoService;

    @GetMapping("PondAndDirection")
    public Map<String, Object> getDirectionsAndShapes(@RequestParam String element) {
        List<String> directions = infoService.getDirections(element);
        List<String> shapes = infoService.getShapes(element);

        Map<String, Object> response = new HashMap<>();
        response.put("element", element);
        response.put("directions", directions);
        response.put("shapes", shapes);

        return response;
    }
    @GetMapping("Koi")
    public List<Koi> getKoiByElement(@RequestParam String elementName) {
        return infoService.getKoiByElement(elementName);
    }
}


