package com.example.assignment.controller.dto;

import com.example.assignment.model.Product;
import com.example.assignment.model.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ProductReadModel {
    private Long id;
    private String name;
    private String description;
    private List<ReviewReadModel> reviews;
    private boolean reviewable;
    private boolean onlyBuyersCanReview;
    private Long reviewCount;
    private Float averageRating;

    public static ProductReadModel fromEntity(Product product) {
        var productReadModel = new ProductReadModel();
        productReadModel.setId(product.getId());
        productReadModel.setName(product.getName());
        productReadModel.setDescription(product.getDescription());
        productReadModel.setReviewable(product.isReviewable());
        productReadModel.setOnlyBuyersCanReview(product.isOnlyBuyersCanReview());
        productReadModel.setReviewCount(product.getReviewCount());
        productReadModel.setAverageRating(product.getAverageRating());
        productReadModel.setReviews(product.getReviews().stream().map(ReviewReadModel::fromEntity).collect(Collectors.toList()));
        return productReadModel;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReviewReadModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewReadModel> reviews) {
        this.reviews = reviews;
    }

    public boolean isReviewable() {
        return reviewable;
    }

    public void setReviewable(boolean reviewable) {
        this.reviewable = reviewable;
    }

    public boolean isOnlyBuyersCanReview() {
        return onlyBuyersCanReview;
    }

    public void setOnlyBuyersCanReview(boolean onlyBuyersCanReview) {
        this.onlyBuyersCanReview = onlyBuyersCanReview;
    }

    public Long getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Long reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }
}
