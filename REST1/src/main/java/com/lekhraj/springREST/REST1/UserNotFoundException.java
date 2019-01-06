package com.lekhraj.springREST.REST1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//If this exception send response code as NOT FOUND
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException
{
	public UserNotFoundException(String message) {
		super(message);
	}
}
