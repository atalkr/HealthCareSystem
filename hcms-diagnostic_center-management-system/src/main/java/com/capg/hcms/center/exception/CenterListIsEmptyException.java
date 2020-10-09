package com.capg.hcms.center.exception;



public class CenterListIsEmptyException extends RuntimeException{

	public CenterListIsEmptyException(String message)
	{
		super(message);
	}
	public CenterListIsEmptyException()
	{
		super();
	}
	
}
