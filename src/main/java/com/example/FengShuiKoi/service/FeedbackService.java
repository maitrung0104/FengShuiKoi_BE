package com.example.FengShuiKoi.service;

import com.example.FengShuiKoi.entity.Account;
import com.example.FengShuiKoi.entity.Feedback;
import com.example.FengShuiKoi.entity.Plan;
import com.example.FengShuiKoi.exception.EntityNotFoundException;
import com.example.FengShuiKoi.model.FeedbackRequest;
import com.example.FengShuiKoi.repos.AccountRepository;
import com.example.FengShuiKoi.repos.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

@Autowired
FeedbackRepository feedbackRepository;

@Autowired
AuthService authService;

@Autowired
AccountRepository   accountRepository;
    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        Account shop = accountRepository.findById(feedbackRequest.getShopId())
                .orElseThrow(() -> new EntityNotFoundException("Shop not found"));
        Feedback feedback = new Feedback();
        feedback.setContent(feedbackRequest.getContent());
        feedback.setRating(feedbackRequest.getRating());
        feedback.setMember(authService.getCurrentAccount());
        feedback.setShop(shop);
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedback() {
        return feedbackRepository.findFeedbackByShopId(authService.getCurrentAccount().getId());
    }
    public void deleteFeedback(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found"));
        feedbackRepository.delete(feedback);
    }
    public Feedback updateFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackRepository.findById(feedbackRequest.getShopId())
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found"));
        feedback.setContent(feedbackRequest.getContent());
        feedback.setRating(feedbackRequest.getRating());
        return feedbackRepository.save(feedback);
    }
}
