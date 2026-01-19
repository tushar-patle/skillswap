package com.tushar.skillswap.challenge.exception;

import com.tushar.skillswap.common.exception.BusinessException;

public class InvalidChallengeStateException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidChallengeStateException(String message) {
		super(message);
	}

}
