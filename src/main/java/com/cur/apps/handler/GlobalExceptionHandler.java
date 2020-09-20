package com.cur.apps.handler;

import com.cur.apps.exceptions.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ServiceException.class})
    public ErrorResponse handleAnyException(ServiceException ex) {
        return new ErrorResponse(ex.getErrorCode(), ex.getErrorCode().getMessage(),
                ex.getTargetParam(), "en");
    }
}


