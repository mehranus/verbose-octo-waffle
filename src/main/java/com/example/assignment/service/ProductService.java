package com.example.assignment.service;

import com.example.assignment.model.Product;
import com.example.assignment.model.Review;
import com.example.assignment.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final LastReviewsService lastReviewsService;

    public ProductService(ProductRepository productRepository, LastReviewsService lastReviewsService) {
        this.productRepository = productRepository;
        this.lastReviewsService = lastReviewsService;
    }


    public Page<Product> getAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size)).map(p -> {
            p.setReviews(lastReviewsService.getLastReviews(p.getId()));
            return p;
        });
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public void updateReviewAverage(Review review) {
        var product = review.getProduct();
        float newAverageRating;
            newAverageRating = ((product.getAverageRating() * product.getReviewCount()) + review.getRating()) / (product.getReviewCount() + 1);

        product.setAverageRating(newAverageRating);
        product.setReviewCount(product.getReviewCount() + 1);
        productRepository.save(product);
    }
}
