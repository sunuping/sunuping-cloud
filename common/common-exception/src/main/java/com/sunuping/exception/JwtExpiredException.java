package com.sunuping.exception;

/**
 * @author lime
 */
public class JwtExpiredException  extends RuntimeException{
    public JwtExpiredException(String message) {
        super(message);
    }

    public JwtExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
