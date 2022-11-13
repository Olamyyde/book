package com.example.book.exception.handler;

import com.example.book.exception.CourseNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CourseNotFoundException.class})
    public ResponseEntity<?> handleCourseNotFound(CourseNotFoundException courseNotFoundException, WebRequest webRequest){
        return super.handleExceptionInternal(courseNotFoundException, courseNotFoundException.getMessage(), new HttpHeaders(),
                HttpStatus.NOT_FOUND, webRequest);
    }
}
