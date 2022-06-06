package com.example.assignment.repository;

import com.example.assignment.model.Product;
import com.example.assignment.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {
}
