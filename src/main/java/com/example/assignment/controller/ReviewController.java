package com.example.assignment.controller;

import com.example.assignment.controller.dto.AddReviewRequest;
import com.example.assignment.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("{ProductId}/review")
    public void addReview(@PathVariable("ProductId") Long productId, @RequestBody AddReviewRequest dto) {
        reviewService.addReview(dto.toEntity(), productId);
    }

    @PostMapping("review/{ReviewId}/approve")
    public void approveReview( @PathVariable("ReviewId") Long reviewId) {
        reviewService.approveReview(reviewId);
    }
}
