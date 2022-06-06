package com.example.assignment.service;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User Is Not Buyer")
public class UserIsNotBuyerException extends RuntimeException {
}
