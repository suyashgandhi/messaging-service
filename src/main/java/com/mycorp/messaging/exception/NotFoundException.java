package com.mycorp.messaging.exception;

/**
 * Exception representing entity not found condition.
 *
 * @author sgandhi
 */
public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }
}
