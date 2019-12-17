package com.exercice.converters.exceptions;

public class TooHighValue extends Exception { 
    public TooHighValue(String errorMessage) {
        super(errorMessage);
    }
}