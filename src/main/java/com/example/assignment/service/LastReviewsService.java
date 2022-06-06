package com.example.assignment.service;

import com.example.assignment.model.LastReviews;
import com.example.assignment.model.Review;
import com.example.assignment.repository.LastReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LastReviewsService {

    private final LastReviewsRepository lastReviewsRepository;

    public LastReviewsService(LastReviewsRepository lastReviewsRepository) {
        this.lastReviewsRepository = lastReviewsRepository;
    }


    public List<Review> getLastReviews(Long productId) {
        return lastReviewsRepository.findById("product" + productId)
                .map(LastReviews::getReviews)
                .orElse(Collections.emptyList());
    }


    public void updateLastReviews(Review review) {
        var product = review.getProduct();
        review.setProduct(null);

        lastReviewsRepository.findById("product" + product.getId()).map(lastReviews -> {
            var reviews = lastReviews.getReviews();
            if (reviews.size() == 3)
                reviews.remove(2);
            reviews.add(review);
            Collections.rotate(reviews, 1);
            lastReviews.setReviews(reviews);
            return lastReviewsRepository.save(lastReviews);
        }).orElseGet(() -> {
            var lastReviews = new LastReviews("product" + product.getId(), Collections.singletonList(review));
            return lastReviewsRepository.save(lastReviews);
        });
    }
}
