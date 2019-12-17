package com.exercice.converters.exceptions;

public class TooManyDecimals extends Exception { 
    public TooManyDecimals(String errorMessage) {
        super(errorMessage);
    }
}