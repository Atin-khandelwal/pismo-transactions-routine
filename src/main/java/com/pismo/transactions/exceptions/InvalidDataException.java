package com.pismo.transactions.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
@RequiredArgsConstructor
public class InvalidDataException extends RuntimeException{
    private final String message;

}
