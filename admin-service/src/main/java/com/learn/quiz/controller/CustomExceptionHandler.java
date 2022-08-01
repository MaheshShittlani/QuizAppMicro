package com.learn.quiz.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.learn.quiz.dto.Response;
import com.learn.quiz.exceptionHandler.CustomException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(IOException.class)
	public ResponseEntity<Response> ioExceptionHandler(IOException ex, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<Response>(new Response("Unable to access."), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Response> customExceptionHandler(CustomException ex, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<Response>(new Response(ex.getLocalizedMessage()), ex.getHttpStatus());
	}
}
