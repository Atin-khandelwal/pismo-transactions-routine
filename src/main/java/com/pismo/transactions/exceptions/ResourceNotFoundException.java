package com.pismo.transactions.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.service.annotation.HttpExchange;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private final String message;
}
