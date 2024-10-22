package com.example.FengShuiKoi.model;

import lombok.Data;

@Data
public class FeedbackRequest {
     String content;
     int rating;
     long shopId;
}
