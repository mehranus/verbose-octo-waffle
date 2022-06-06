package com.example.assignment.service;

import com.example.assignment.model.Review;
import com.example.assignment.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductService productService;
    private final LastReviewsService lastReviewsService;
    private final UserService userService;

    public ReviewService(ReviewRepository reviewRepository,
                         LastReviewsService lastReviewsService,
                         ProductService productService,
                         UserService userService) {
        this.reviewRepository = reviewRepository;
        this.lastReviewsService = lastReviewsService;
        this.productService = productService;
        this.userService = userService;
    }

    public void addReview(Review review, Long productId) {
        var product = productService.getProduct(productId);
        if (!product.isReviewable())
            throw new ProductIsNotReviewableException();
        if (product.isOnlyBuyersCanReview())  {
            if (!userService.isBuyer(review.getUserId(),productId)){
                throw new UserIsNotBuyerException();
            }
        }

            review.setProduct(product);
        reviewRepository.save(review);
    }

    public Review approveReview(Long id) {
        return reviewRepository.findById(id).map(r -> {
            r.setApproved(true);
            productService.updateReviewAverage(r);
            lastReviewsService.updateLastReviews(r);
            return reviewRepository.save(r);
        }).orElseThrow(ReviewNotFoundException::new);

    }

}
