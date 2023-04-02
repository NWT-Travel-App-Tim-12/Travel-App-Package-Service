package com.app.travel.util;

import com.app.travel.util.exceptions.FieldNameBaseException;
import com.app.travel.util.exceptions.InvalidAdditionalDataCast;
import com.app.travel.util.exceptions.MissingParameterInRequest;
import com.app.travel.util.exceptions.ObjectDoesNotExistInDb;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", new Date());
        responseBody.put("status", status.value());
        responseBody.put("errors",
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage))
        );
        return new ResponseEntity<>(responseBody, headers, status);
    }

    @ExceptionHandler({
            MissingParameterInRequest.class,
            ObjectDoesNotExistInDb.class,
            InvalidAdditionalDataCast.class
    })
    public ResponseEntity<Object> customErrors(FieldNameBaseException exception){
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", new Date());
        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
        var errors = new HashMap<String, String>();
        errors.put(exception.getFieldName(), exception.getMessage());
        responseBody.put("errors", errors);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseBody);
    }
}
