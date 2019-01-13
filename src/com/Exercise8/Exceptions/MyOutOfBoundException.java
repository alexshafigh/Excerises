package com.Exercise8.Exceptions;

public class MyOutOfBoundException extends Exception {
    private static String message;

    public MyOutOfBoundException(String s) {
//        super(s);
        message = s;
    }

    public MyOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
//        return super.toString();
//        return "Exception Thrown In " + message;
        return message;
    }
}
