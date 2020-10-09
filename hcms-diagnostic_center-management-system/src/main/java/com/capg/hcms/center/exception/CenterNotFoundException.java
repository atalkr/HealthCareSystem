package com.capg.hcms.center.exception;


public class CenterNotFoundException extends RuntimeException{

	public CenterNotFoundException(String message)
	{
		super(message);
	}
	public CenterNotFoundException()
	{
		super();
	}
	
}
