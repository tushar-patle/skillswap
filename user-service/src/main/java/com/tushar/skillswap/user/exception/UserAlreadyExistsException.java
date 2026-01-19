package com.tushar.skillswap.user.exception;

import com.tushar.skillswap.common.exception.BusinessException;

public class UserAlreadyExistsException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  UserAlreadyExistsException(String message) {
		super(message);
	}
	
}
