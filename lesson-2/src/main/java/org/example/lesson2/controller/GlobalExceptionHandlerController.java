package org.example.lesson2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController
{
  private static final Logger log = LoggerFactory.getLogger( GlobalExceptionHandlerController.class );

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception err) {
      log.error( "Exception: {}", err );
      log.error( "Exception message: {}",
        err.getMessage() );
      log.error( "Exception type: {}",
        err.getClass().getName() );

      return ResponseEntity.status( 500 ).body( "Internal server error" );
    }
}
