package br.com.developeralexandresantos.santander_dev_week.exception;

import br.com.developeralexandresantos.santander_dev_week.exception.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
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

    @Hidden
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ErrorResponse(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value()));
    }

    @Hidden
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NoSuchElementException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("Resource not found", HttpStatus.NOT_FOUND.value()));
    }

    @Hidden
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        logger.error(UNEXPECTED_SERVER_ERROR, ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(UNEXPECTED_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
