package com.example.assignment.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "review Not Found")
public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException() {
        super("review not found");
    }
}
