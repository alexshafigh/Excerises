package com.Exercise9.Exceptions;

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return super.getMessage() + "caused by " + super.getCause();
    }
}
