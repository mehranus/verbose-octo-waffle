package com.example.assignment.controller.dto;

import com.example.assignment.model.Review;

public class ReviewReadModel {

    private String comment;
    private float rating;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }



    public static ReviewReadModel fromEntity(Review entity) {
        ReviewReadModel model = new ReviewReadModel();
        model.setComment(entity.getComment());
        model.setRating(entity.getRating());
        return model;
    }

}
