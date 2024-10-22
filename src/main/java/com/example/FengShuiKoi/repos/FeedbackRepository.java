package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Feedback;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findFeedbackByShopId(Long shopId);
}
