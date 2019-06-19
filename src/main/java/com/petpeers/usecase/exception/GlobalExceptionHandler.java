package com.petpeers.usecase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.petpeers.usecase.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseDto> dataNotFoundExceptionHandler(Exception ex){
		ResponseDto rdo=new ResponseDto();
		rdo.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(rdo, HttpStatus.NOT_FOUND);
		
	}
	
	
	

}
