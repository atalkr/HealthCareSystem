package com.capg.hcms.center.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.center.exception.CenterListIsEmptyException;
import com.capg.hcms.center.exception.CenterNameAlreadyExistException;
import com.capg.hcms.center.exception.CenterNotFoundException;
import com.capg.hcms.center.exception.TestNameAlreadyExistException;

/**************************************************************************
 * @author      Divya 
 * Description  It is the error handling class for center management
 * Created Date 07-Oct-2020
 **************************************************************************/

@RestController
@ControllerAdvice
public class DiagnosticCenterErrorHandler {

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Center Name Already Exist")
	@ExceptionHandler(CenterNameAlreadyExistException.class)
	public void handleCenterNameAlreadyExistException() {
		// CenterName Already Exist Exception
	}

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Test Name Already Exist")
	@ExceptionHandler(TestNameAlreadyExistException.class)
	public void handleCenterTestAlreadyExistException() {
		// CenterName Already Exist Exception
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Center Not Found ")
	@ExceptionHandler(CenterNotFoundException.class)
	public void handleCenterNotFoundException() {
		// Center Not Found Exception
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "CenterList is Empty ")
	@ExceptionHandler(CenterListIsEmptyException.class)
	public void handleCenterListIsEmptyException() {
		// CenterList is Empty Exception
	}
}
