package ua.com.app.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlingController {

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<Object> handleAll(RuntimeException ex, WebRequest request) {
    ApiError apiError = new ApiError(
        HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), "Requested entity was not found");
    return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
  }
}
