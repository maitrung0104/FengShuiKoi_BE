package com.example.FengShuiKoi.controller;

import com.example.FengShuiKoi.entity.Feedback;
import com.example.FengShuiKoi.entity.Plan;
import com.example.FengShuiKoi.model.FeedbackRequest;
import com.example.FengShuiKoi.service.FeedbackService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@SecurityRequirement(name = "api")
@CrossOrigin(origins = "*")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity createFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackService.createFeedback(feedbackRequest);
        return ResponseEntity.ok(feedback);
    }
    @GetMapping
    public ResponseEntity getFeedback() {
        List<Feedback> feedback = feedbackService.getFeedback();
        return ResponseEntity.ok(feedback);
    }
    @DeleteMapping
    public ResponseEntity deleteFeedback(@RequestParam Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity updateFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackService.updateFeedback(feedbackRequest);
        return ResponseEntity.ok(feedback);
    }
}
