package com.example.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("lastReviews")
public class LastReviews implements java.io.Serializable {
    @Id
    private String productId;
    private List<Review> reviews;

    public LastReviews(String productId, List<Review> reviews) {
        this.productId = productId;
        this.reviews = reviews;
    }

    public LastReviews() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
