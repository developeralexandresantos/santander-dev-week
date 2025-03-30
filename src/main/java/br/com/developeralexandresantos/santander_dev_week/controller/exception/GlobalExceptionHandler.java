package br.com.developeralexandresantos.santander_dev_week.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public static final String UNEXPECTED_SERVER_ERROR = "Unexpected server error, see the logs.";

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleGenericException(Throwable unexpectedException) {
        logger.error(UNEXPECTED_SERVER_ERROR, unexpectedException);
        return new ResponseEntity<>(UNEXPECTED_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
