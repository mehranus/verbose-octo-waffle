package com.example.assignment.controller.dto;

import com.example.assignment.model.Review;

public class AddReviewRequest {
    private String review;
    private float rating;

    public Review toEntity() {
        return new Review(review, rating);
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
