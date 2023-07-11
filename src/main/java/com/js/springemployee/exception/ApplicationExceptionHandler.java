package com.js.springemployee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.js.springemployee.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler   {
	 
	@ExceptionHandler(value= NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdFound(NoIdFoundException e){
		
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setData("Not Found");
		res.setMessage(e.getMessage());
		res.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(res,HttpStatus.NOT_FOUND);
	}
}
