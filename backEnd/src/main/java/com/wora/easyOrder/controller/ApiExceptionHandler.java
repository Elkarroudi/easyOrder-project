package com.wora.easyOrder.controller;

import com.wora.easyOrder.util.apiResponse.fail.FailDTO;
import com.wora.easyOrder.util.apiResponse.fail.FailType;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * Handles BadRequestException and returns a bad request error response.
     *
     * @param ex The exception thrown when a bad request occurs.
     * @return A FailDTO with a bad request status and an error message.
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FailDTO handleBadRequestException(BadRequestException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("error", ex.getMessage());

        return new FailDTO(
                HttpStatus.BAD_REQUEST.value(),
                FailType.BAD_REQUEST,
                errors
        );
    }

    /**
     * Handles MethodArgumentNotValidException and returns validation error responses.
     *
     * @param ex The exception thrown when validation fails on a method argument.
     * @return A FailDTO with a validation error status and field-specific error messages.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FailDTO handleValidationExceptions(final MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            final String fieldName = ((FieldError) error).getField();
            final String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new FailDTO(
                HttpStatus.NOT_ACCEPTABLE.value(),
                FailType.VALIDATION_ERROR,
                errors
        );
    }

    /**
     * Handles HttpMessageNotReadableException and returns an error response for unreadable request body.
     *
     * @param ex The exception thrown when the request body is unreadable.
     * @return A FailDTO with a bad request status and a descriptive error message.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FailDTO handleMissingRequestBody(HttpMessageNotReadableException ex) {
        return new FailDTO(
                HttpStatus.BAD_REQUEST.value(),
                FailType.HTTP_MESSAGE_NOT_READABLE,
                "Request body is missing or unreadable"
        );
    }

}
