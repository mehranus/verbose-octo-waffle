package com.example.assignment.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "product Not Found")
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("product not found");
    }
}
