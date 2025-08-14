package com.sensui.taskmanager.exception.handler;

import com.sensui.taskmanager.exception.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class HibernateExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, List<ValidationError>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return mapFieldErrors(ex);
    }

    private Map<String, List<ValidationError>> mapFieldErrors(MethodArgumentNotValidException ex) {
        Map<String, List<ValidationError>> messagesMap = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();

            ValidationError ValidationError = new ValidationError(message);
            createOrAddError(field, ValidationError, messagesMap);
        }
        return messagesMap;
    }

    private void createOrAddError(String field, ValidationError ValidationError,
                                  Map<String, List<ValidationError>> messagesMap) {

        List<ValidationError> errors = new ArrayList<>();
        if (messagesMap.containsKey(field)) {
            errors.addAll(messagesMap.get(field));
            errors.add(ValidationError);
        } else {
            errors.add(ValidationError);
        }
        messagesMap.put(field, errors);
    }
}