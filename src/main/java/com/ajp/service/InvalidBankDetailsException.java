package com.ajp.service;

public class InvalidBankDetailsException extends Exception {
	public InvalidBankDetailsException(String message) {
        super(message);
    }
}
